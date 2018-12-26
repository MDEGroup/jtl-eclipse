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

package jaspwrapper.tools;

import jaspwrapper.exception.JASPException;

import jaspwrapper.exec.EngineRunner;
import jaspwrapper.exec.Grounder;
import jaspwrapper.exec.Program;
import jaspwrapper.exec.Solver;

import java.util.HashMap;
import java.util.LinkedList;


/**
 * JASPWrapper - Java Answer Set Programming Wrapper - is a java wrapper for answer set programs.
 * 
 * <br><br>
 * Stand-alone use
 * <br><br>
 * <PRE>
 * java jaspwrapper.tools.JASPWrapper file(s) OPTIONS 
OPTIONS:
    -solver           path/to/solver
    -os               type                 Available: windows,unix
    [-solverOptions   options]             Passed to the solver, put in double quotes
                                           i.e "-nolookahead"]
    [-grounder        path/to/grounder]
    [-grounderOptions options]             Passed to the grounder, put in double quotes 
                                           i.e. "-c n=8 -D"]

 * </PRE>
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class JASPWrapper {
    
    private EngineRunner engine;
    private Grounder grounder;
    private Solver solver;
    private String grounderPath;
    private String solverPath;
    private String grounderOptions;
    private String solverOptions;
    private String os;
    private Program program;
    private LinkedList <String> filenames;
    private HashMap <String,String> options;


    public JASPWrapper(String[] args) {
        try {
            options         = new HashMap <String,String>();
            filenames       = new LinkedList <String>();
            
            solverPath      = "";
            solverOptions   = "";
            grounderPath    = "";
            grounderOptions = "";
            os              = "";
          
            
            // Init options map
            options.put("-solver","");
            options.put("-solverOptions","");
            options.put("-grounder","");
            options.put("-grounderOptions","");
            options.put("-os","");
            
            
            if (args.length == 0) {
                printError("You must define parameters");
                usage();
                System.exit(0);
            }
            
            // Read one ....
            int i = 0;
            
            if (!(args[i].startsWith("-"))) {
                filenames.add(args[i]);
            } 
            else {
                printError("First you must define source program");
                usage();
                exit();
            }
            
            //Next token...
            i++;
            
            //...or more files
            while ((i < args.length) && !(args[i].startsWith("-"))) {
                if (!filenames.contains(args[i])) {
                    filenames.add(args[i]);
                    i++;
                } 
                else {
                    printError("You are set identical source files");
                    usage();
                    exit();
                }
            }  
            
            // checks if options are set
            if (i == args.length) {
                printError("You must define parameters");
                usage();
                exit();
            }
          
            
            // checks if each option has his value set
            if (((args.length-i) % 2) !=0 ) {
                printError("Error in options");
                usage();
                exit();
            }
                    
                
            while (i+1 < args.length) {
                // if option read is inside correct options
                if (options.containsKey(args[i])) {  
                    // if options is not set
                    if (options.get(args[i]).equals("")) {
                        if (!args[i].equals("-solverOptions") && !args[i].equals("-grounderOptions")) {
                            // if value does not start with "-"
                            if(!args[i+1].startsWith("-")) {
                                options.put(args[i],args[i+1]);
                            }
                            else {
                                printError("\"" + args[i] + "\"" + "parameter value not found");
                                usage();
                                exit();
                            }      
                        } 
                        // value of solverOptions and grounderOptions can start with and without "-"
                        else {
                            options.put(args[i],args[i+1]);
                        }
                    }
                    else {
                        printError("Too options defined for \"" + args[i] + "\"" + " parameter");
                        usage();
                        exit();
                    }
                }
                else {
                    printError("Error parameter name  \"" + args[i] + "\"");
                    usage();
                    exit();
                }
              i = i + 2;
            }
            
            // init option variables
            solverPath      = options.get("-solver");
            solverOptions   = options.get("-solverOptions");
            grounderPath    = options.get("-grounder");
            grounderOptions = options.get("-grounderOptions");
            os              = options.get("-os");
 
        
            // checks if essential options are set (file,solver,os)
            if ((filenames.size()!=0) && (solverPath != "") && (os != "")) {
                // checks if grounderOptions are set while no grounder are set                
                if ((grounderOptions != "") && (grounderPath =="")) {
                    printError("You are set grounderOptions parameters but grounder parameter is not found");
                    usage();
                    exit();
                }
            }
            else {
                printError("Essential parameters are not set - (solver,os)");
                usage();
                exit();
            }
  
            program = new Program();
            
            for (String item : filenames){
                program.addFromFile(item);
            }
            
            program.end();
                                
            solver = new Solver(solverPath);
                
            if (solverOptions != "") {
                solver.setOptions(solverOptions);
            }
            
            //If grounder is set
            if (grounderPath != "") {
                grounder = new Grounder(grounderPath);
                grounder.setOptions(grounderOptions);
                engine = new EngineRunner(solver,grounder);
            }
            else {
                engine = new EngineRunner(solver);
            }
                
            engine.setOS(os);
            engine.loadProgram(program);
            engine.setOutputConsole(true);
            engine.compute();
        } 

        catch (JASPException ase) {
            System.out.println(ase);
        }
    }

    public static void main(String[] args) {
        JASPWrapper jASPWrapper = new JASPWrapper(args);
    }

    private void usage() {
        System.out.println();
        System.out.println("****************");
        System.out.println("JASPWrapper 0.9 ");
        System.out.println("****************");
        System.out.println("Usage:");
        System.out.println();
        System.out.println("java jaspwrapper.tools.JASPWrapper file(s) OPTIONS");
        System.out.println();
        System.out.println("OPTIONS:");
        System.out.println("    -solver           path/to/solver");
        System.out.println("    -os               type                 Available: windows,unix");        
        System.out.println("    [-solverOptions   options]             Passed to the solver, put in double quotes");
        System.out.println("                                           i.e \"-nolookahead\"]");
        System.out.println("    [-grounder        path/to/grounder]");
        System.out.println("    [-grounderOptions options]             Passed to the grounder, put in double quotes "); 
        System.out.println("                                           i.e. \"-c n=8 -D\"  ]");
    }    

    public void printError(String error) {
        System.out.println();
        for (int i = 0 ; i < error.length() ; i++) {
            System.out.print("*");
        }
        
        System.out.println("\n" + error);
        
        for (int i = 0 ; i < error.length() ; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public void exit() {
        System.exit(0);
    }
}
