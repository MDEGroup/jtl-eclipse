/*
Copyright (C) 2008  <Giovanni Pirrotta>

This file is part of JASPWrapper.

JASPWrapper is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JASPWrapper is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JASPWrapper.  If not, see <http://www.gnu.org/licenses/>.
*/

package jaspwrapper.exec;

import jaspwrapper.analyzer.OutputAnalyzer;
import jaspwrapper.analyzer.OutputAnalyzerFactory;

import jaspwrapper.exception.JASPException;

import jaspwrapper.items.Model;

import jaspwrapper.output.OutputResult;

import jaspwrapper.util.Timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/**
 * EngineRunner class is the core of JASPWrapper.
 * <br><br>
 * Example of usage as library with SMODELS output format:
 * <br><br>
 * Builds a program object
 * <br>
 * <code>
 * Program program = new Program();
 * </code>
 * <br>
 * <br>
 * Loads a program from file
 * <br>
 * <code>
 * program.addFromFile("d:\\queens.sm");     <br>          
 * program.end(); 
 * </code> <br>
 * <br>
 * Configuration of Grounder  and Solver objects
 * <br>
 * <code>
 * Grounder grounder = new Grounder ("d:\\programs\\asp\\lparse.exe");<br>
 * Solver   solver   = new Solver ("d:\\programs\\asp\\smodels.exe");<br>
 * </code>
 * <br>
 * Builds an <b>engine</b> instance
 * <br>
 * <code>
 * EngineRunner myEngine = new  EngineRunner(grounder,solver);<br>
 * </code>
 * <br>
 * Sets operating system
 * <br>
 * <code>
 * myEngine.setOS("windows");
 * </code>
 * <br>
 * <br>
 * Sets operating system
 * <br>
 * <code>
 * myEngine.setSolverType(OutputAnalyzerFactory.SMODELS);
 * </code>
 * <br><br>
 * 
 * Loads engine
 * <br>
 * <code>
 * myEngine.loadProgram(program);<br>
 * </code>
 * <br>
 * Starts computation
 * <br>
 * <code>
 * myEngine.compute(EngineRunner.ONE_MODEL_AT_ONCE);<br>
 * </code>
 * <br>
 * Prints answer sets
 * <br>
 * <PRE>
 * while (myEngine.hasMore()) { 
 *     Model model = myEngine.next(); 
 *     for(Iterator itAtom = model.iterator(); itAtom.hasNext();) { 
 *         Atom atom = (Atom) itAtom.next(); 
 *         System.out.println(atom.getName()); 
 *         for(Iterator itArg = atom.iterator(); itArg.hasNext();) { 
 *             Constant constant = (Constant) itArg.next(); 
 *             System.out.println(constant); 
 *         } 
 *     } 
 * } 
 * </PRE>
 * 
 * or
 * 
 * <PRE>
 * while (myEngine.hasMore()) { 
 *     Model model = myEngine.next(); 
 *     System.out.println(model); 
 * }
 * </PRE>
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class EngineRunner {


    private Program program;
    private BufferedReader solverOutput;
    private Process process;
    private Grounder grounder;
    private Solver solver;
    private String OS;
    private int solverType;
    private Vector <Model> models;
    private boolean outputConsole;
    private boolean modelReady;
    private Iterator iterator;
    private int mode;
    private int count;
    private int status;
    private StringBuffer errorMessage;
    private OutputAnalyzerFactory formatFactory;
    private Timer timer;
    private int numberModels;
    private List <OutputResult> outputResultListeners;
    
    
    public static final int INIT                 = 0;
    public static final int RUN                  = 1;
    public static final int END                  = 2;
    
    /**
     * Synchronous mode
     */
    public static final int ALL_MODEL_AT_ONCE    = 0;
    
    /**
     * Asynchronous mode
     */
    public static final int ONE_MODEL_AT_ONCE    = 1;
    
    public static final int INPUT_STREAM         = 0;
    public static final int ERROR_STREAM         = 1;
    
    private final Lock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    
    private EngineRunner() {
        program         = null;
        solverOutput    = null;
        process         = null;
        models          = new Vector <Model>();
        outputConsole   = false;
        iterator        = null;
        modelReady      = false;
        status          = INIT;
        mode            = ALL_MODEL_AT_ONCE;       //default
        errorMessage    = new StringBuffer();
        formatFactory   = new OutputAnalyzerFactory();
        solverType      = OutputAnalyzerFactory.SMODELS;  //default
        timer           = new Timer();
        count           = 0;
        numberModels    = 0;
        outputResultListeners = new ArrayList <OutputResult>();
        
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    /**
     * Build an instance of EngineRunner without grounder
     * 
     * @param  solverCfg       A configuration for a solver 
     */
    
    public EngineRunner (Solver solverCfg) throws JASPException {
        this();
        if (solverCfg == null) throw new JASPException ("Set solver object, please");
        
        solver   = solverCfg;
        grounder = null;

    }

    /**
     * Builds an instance of EngineRunner
     * 
     * @param  solverCfg       A configuration for a solver 
     * @param  grounderCfg     A configuration for a grounder 
     */
    
    public EngineRunner(Solver solverCfg, Grounder grounderCfg) throws JASPException {
        this();
        if (solverCfg == null) throw new JASPException ("Set solver object, please");
        if (grounderCfg == null) throw new JASPException ("Set grounder object, please");
        grounder  = grounderCfg;
        solver    = solverCfg;
    }
        
    /**
     * Loads program(s) to compute
     * 
     * @throws JASPException If end method is not invoked
     */    
    
    public void loadProgram(Program program) throws JASPException {
        if (! program.endProgram()) throw new JASPException ("End method not invoked");
        this.program = program;
    }

    
    /**
     * Starts logic computation 
     * 
     * @param mode Compute mode (EngineRunner.ALL_MODEL_AT_ONCE - EngineRunner.ONE_MODEL_AT_ONCE)
     * 
     * @throws JASPException If operating system  not set
     */  
    
    public void compute(int mode) {
        this.mode = mode;
        try {
            compute();
        }
        catch(JASPException jasp) {
            System.out.println(jasp);
            System.exit(0);
        }
    }
    
    /**
     * Starts logic computation (ALL_MODEL_AT_ONCE  - default)
     * 
     * @throws JASPException If operating system is not set
     */
        
    public void compute() throws JASPException{
        try {
            if (getOS() == null) throw new JASPException("Set your operating system, please");
    
            String[] command = generateCommand();
            
            System.out.println("JASPWrapper 0.9 - Command executing...");
            
            
            for (int i = 0 ; i < command.length ; i++) {
                System.out.print (command[i]+ " ");
            }
            System.out.println();
            System.out.println("--------------------- ");
            
            
            setStatus(RUN);
            process = new ProcessBuilder(command).start();
            
            //process = Runtime.getRuntime().exec(command); // used in previous versions
            
            StreamManager outputStreamManager = new StreamManager(process.getInputStream(), INPUT_STREAM ,this);   
            StreamManager errorStreamManager  = new StreamManager(process.getErrorStream(), ERROR_STREAM, this);            
            
            outputStreamManager.start();
            errorStreamManager.start();
                                             
        } 
        catch (IOException e) { 
            e.printStackTrace();
            System.exit(0);
        }
        catch (Throwable t) {
            t.printStackTrace();
            System.exit(0);
        }                   
    }
    
    /**
     * Starts logic computation to produce specific output results
     * @param mode Compute mode (EngineRunner.ALL_MODEL_AT_ONCE | EngineRunner.ONE_MODEL_AT_ONCE)
     * @param outputResult If true, this computation produces specific output results
     */
    
    public void compute(int mode, boolean outputResult) {
        
        compute(mode);
        if (outputResult) {
            fireStartEvent();
            while(hasMoreModel()) {
                Model model = nextModel();
                fireNewModelEvent(model);
            }
            fireEndEvent();
        }
        
        
    }
    
 
    /**
     * Generates command-line
     * 
     * @return Array of String command
     * @throws JASPException If Program if not set
     */
    
    private String[] generateCommand() throws JASPException {
    
        if (program == null) throw new JASPException("Set Program before run ASPSolver");
        
        ArrayList <String> inputFiles = program.getLoadedFiles();
        StringBuffer tmp = new StringBuffer();
        String[] init = new String[3]; 
        
        if (getOS().equalsIgnoreCase("windows")) {
            init[0] = "cmd";
            init[1] = "/C";
        }
        else if (getOS().equalsIgnoreCase("unix")) {
            init[0] = "/bin/sh";
            init[1] = "-c";
        }
        
        tmp.append(" ");
        
        // If grounder is not set - only solver
        if (grounder != null) {
            tmp.append(grounder.getExec());
            tmp.append(" ");
            
            tmp.append(grounder.getOptions());
            
            tmp.append(" ");
            
            for (String item : inputFiles) {
                tmp.append(item + " ");
            }
        
            // pipe
            tmp.append(" | ");
        }
        tmp.append(solver.getExec());
        tmp.append(" ");
            
        //Set number stable model to 0 if no option and grounder are set
        if ((grounder != null) && (solver.getOptions() == "")) {
            solver.setOptions(" 0 ");
        }
        tmp.append(solver.getOptions());
        tmp.append(" ");
        
        // if grounder is not set put input file here
        if (grounder == null) {
            for (String item : inputFiles) {
                tmp.append(item + " ");
            }     
        }
  
        init[2] = tmp.toString();
        return init;
    }

    /**
     * Sets operating system
     * 
     * @param OS type of operating system (type: windows, unix) - <br>OS Supported : GNU/Linux, Microsoft Windows NT, Windows 2000, Windows XP
     * @throws JASPException If operating system is wrong set
     */
    
    public void setOS(String OS) throws JASPException {
        if (!OS.equals("windows") && (!OS.equals("unix"))) {
            throw new JASPException("Error in operating system");
        }
        this.OS = OS;
    }

    
    /**
     * Returns System Operating type
     * 
     * @return type of OS
     */
    
    private String getOS() {
        return OS;
    }

   
    /**
     * Adds model in engine
     * 
     * @param model Model to add
     */
    
    public void addModel(Model model) {
        lock.lock();
        try {
            numberModels++;
            if (mode == ONE_MODEL_AT_ONCE) {
                while ((models.size() == 1) && (status == RUN)) {
                    notFull.await();
                }
                models.add(model); 
                notEmpty.signal();
            }
            else { //SYNCHRONOUS_MODE
                models.add(model);
            }
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
        finally {
            lock.unlock();
        }
    }
        
        
    /**
     * Verifies if a model is present
     * 
     * @return Returns true while engine find models
     * 
     * @throws InterruptedException Problem in thread-life
     */
     
    public boolean hasMoreModel() {
        lock.lock();
        try {
            switch (mode) {
                case ALL_MODEL_AT_ONCE :
                    while ((status == RUN)) {
                       notEmpty.await();
                    }
                    break;
   
                case ONE_MODEL_AT_ONCE :
                    while ((models.size() == 0) && (status == RUN)) {
                        notEmpty.await();
                    }
                    break;
            }
        }
        catch (InterruptedException ie ){
            ie.printStackTrace();
            System.exit(0);
        }
        finally {
            lock.unlock();
        }
        return (count < models.size());
    }

   
   /**
    * Gets computed model
    * 
    * @throws InterruptedException Problem in thread
    */
    public Model nextModel() {
        lock.lock();
        Model model = null;
        try {
            if (mode == ALL_MODEL_AT_ONCE) {
                model = models.get(count);
                count++;
            } 
            else if (mode == ONE_MODEL_AT_ONCE) {
                model = models.get(0);
                models.remove(0);
                notFull.signal();
            }
        }
        finally {
            lock.unlock();
        }
        return model;
    }
    
    /**
     * Sets output to console
     */
    public void setOutputConsole(boolean outputConsole) {
        this.outputConsole = outputConsole;
    }

    /**
     * Gets number models
     * 
     * @return Number models
     */
    public int getNumberModels() {
        return numberModels;
    }

    /**
     * Sets status
     * 
     * @param status Engine status (INIT,GO,END)
     */
    public void setStatus(int status) {
        lock.lock();
        try {
            this.status = status;
            if (status == END) {
                notEmpty.signal();
            }
        }
        finally{
            lock.unlock();
        }
    }
    
    /**
     * Appends error message into engine
     * 
     * @param message Message to append
     */
    
    public void appendErrorMessage(String message) {
        lock.lock();
        try {
            errorMessage.append(message);
            System.out.println(message);    
        }
        finally {
            lock.unlock();
        }
    }

    /**
     * Gets error message
     * 
     * @return Error message
     */
    public String getErrorMessage() {
        return errorMessage.toString();
    }
    
    /**
     * Gets duration
     * 
     * @return Duration in milliseconds
     */
     
    public long getDuration() {
        return timer.getElapsed();
    }

    /**
     * Sets solver type
     * 
     * @param  solverType Solver Type (Available: OutputAnalyzerFactory.SMODELS - OutputAnalyzerFactory.DLV -  OutputAnalyzerFactory.CLASP)
     */
     
    public void setSolverType(int solverType) {
        this.solverType = solverType;
    }

    /**
     * Gets solver type
     * 
     * @return solver type
     */
    public int getSolverType() {
        return this.solverType;
    }

    /**
     * New model intercepted
     * 
     * @param model
     */
    
    private void fireNewModelEvent(Model model) {
        for(OutputResult item : outputResultListeners) {
            item.onNewModelEvent(model);
        }             
    }

    /**
     * Signals new computation starting
     */
    
    private void fireStartEvent() {
        for(OutputResult item : outputResultListeners) {
            item.onStartEvent();
        }
    }

    /**
     * Signals new computation ending
     */

    private void fireEndEvent() {
        for(OutputResult item : outputResultListeners) {
            item.onEndEvent();
        }
    }

    /**
     * Adds output result type
     * @param outputResult output result type
     */
    public void addOutputResult(OutputResult outputResult) {
        outputResultListeners.add(outputResult);
    }

    /**
     * Thread Class -  Stream Manager
     */
    private class StreamManager extends Thread {

        private InputStream inputStream;
        private int source;
        private EngineRunner engine;
           

        StreamManager(InputStream inputStream, int source, EngineRunner engine) {
            this.inputStream = inputStream;
            this.source = source;
            this.engine = engine;
        }
           

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                
                if (outputConsole) {
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }
                else {
                    OutputAnalyzer analyzer = OutputAnalyzerFactory.getAnalyzer(solverType);
                    timer.start();
                    analyzer.analyze(engine,mode,source,inputStream);
                    timer.stop();
                }
            }     
            catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(0);
            }
        }
    }    
}