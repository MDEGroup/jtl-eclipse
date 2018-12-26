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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


/**
 * JASPConsole - Java Answer Set Programming Console - is a console for answer set programs.
 * <br><br>
 * Usage:
 * <pre>
 * java jaspwrapper.tools.JASPConsole

 *--------------------------------------------------
 *JASPWrapper 0.9 - Console (help for commands)
 *--------------------------------------------------
 *Commands:
 *   SET SOLVER path                    path/to/solver
 *   SET OS type                        operating system (unix|windows)
 *   [SET GROUNDER path                 path/to/grounder]
 *   [SET SOLVER_OPTIONS "options"      options passed in double quote]
 *   [SET GROUNDER_OPTIONS "options"    options passed in double quote]
 *   START                              enter environment
 *     |------> RUN                     compute models - inside environment
 *     |------> NEW                     creates a new program
 *     |------> UP                      exit environment
 *   QUIT                               exit console
 *> (prompt)
 *</pre>
 *
 * 
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class JASPConsole {

    private Solver solver;
    private Grounder grounder;
    private String os;
    private String solverOptions;
    private String grounderOptions;
    private boolean solverOk;
    private boolean grounderOk;



    public JASPConsole() {
        
        solverOk = false;
        grounderOk = false;
        grounder = null;
        solver = null;
        os = "unix"; //default
        
        startConsole();
    }
    
    private void startConsole() {
        try {
            StringBuffer sb = new StringBuffer();
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer;
            clear();
            help();
            String str = "";
            while (str != null)  {
                System.out.print("> ");  //prompt
                
                str = in.readLine().trim();
                tokenizer = new StringTokenizer(str, " ");
                
                if (tokenizer.hasMoreTokens()) {
                    String command = tokenizer.nextToken();
                    if (command.equalsIgnoreCase("SET")) {    
                        setCommand(tokenizer);
                    }
                    else if (command.equalsIgnoreCase("START")) {
                        //sb = new StringBuffer();
                        String line = "";
                        newCommand();
                        
                        if (sb.length()!=0) {
                            System.out.println(sb.toString());
                        }
                        BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                        
                        
                        
                        while (line != null) {
                            line = in2.readLine().trim();                                   
                                   
                            if (line.equalsIgnoreCase("RUN")) {
                                buildEngine(sb);
                            }  
                            else if(line.equalsIgnoreCase("UP")) {
                                break;
                            }
                            else if (line.equalsIgnoreCase("NEW")) {
                                sb = new StringBuffer();
                                newCommand();
                            }
                            else if (line.equalsIgnoreCase("HELP")) {
                                help();
                            }
                            else if (line.equalsIgnoreCase("QUIT")) {
                                hello();
                                System.exit(0);
                            }
                            else {
                                sb.append(line + "\n"); 
                            }
                        }    
                    }
                    
                    else if (command.equalsIgnoreCase("HELP")) {
                        help();
                    }
                            
                    else if (command.equalsIgnoreCase("QUIT")) {
                        hello();
                        System.exit(0);
                    }
                    else {
                        error();
                    }
                }
            }
               
        } 
        catch (IOException e) { 
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        JASPConsole console = new JASPConsole();
    }

    private void help() {
        clear();
        System.out.println("--------------------------------------------------");
        System.out.println("JASPWrapper 0.9 - Console (help for commands)    ");
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("Commands:   ");
        System.out.println("    SET SOLVER path                     path/to/solver");
        System.out.println("    SET OS type                         operating system (unix|windows)");
        System.out.println("    [SET GROUNDER path                  path/to/grounder]        ");
        System.out.println("    [SET SOLVER_OPTIONS \"options\"       options passed in double quote]");
        System.out.println("    [SET GROUNDER_OPTIONS \"options\"     options passed in double quote]");
        System.out.println("    START                               enter environment");
        System.out.println("    |------> RUN                        compute models - inside environment");
        System.out.println("    |------> NEW                        creates a new program");
        System.out.println("    |------> UP                         exit environment");
        System.out.println("    QUIT                                exit console");
        
        
    }
    private void hello() {
        System.out.println();
        System.out.println("Hello by JASPWrapper...");
    }
   
    private void setCommand(StringTokenizer tokenizer) {
        if (tokenizer.hasMoreTokens()) {
            String type = tokenizer.nextToken();
            if (type.equalsIgnoreCase("GROUNDER")) {
                if(tokenizer.hasMoreTokens()) {
                    String grounderPath = tokenizer.nextToken();
                    grounder = new Grounder (grounderPath);
                    System.out.println("GROUNDER:  " + grounderPath);
                    grounderOk = true;
                } 
                else {
                    error();
                }
            }
            else if (type.equalsIgnoreCase("SOLVER")) {
                if (tokenizer.hasMoreTokens()) {
                    String solverPath = tokenizer.nextToken();
                    solver = new Solver (solverPath);
                    System.out.println("SOLVER:  " + solverPath);
                    solverOk = true;
                }
                else {
                    error();
                }
            }
            else if (type.equalsIgnoreCase("OS")) {
                if (tokenizer.hasMoreTokens()) {
                    os = tokenizer.nextToken();
                    System.out.println("OS:  " + os);
                }
                else {
                    error();
                }
            }
            else if (type.equalsIgnoreCase("SOLVER_OPTIONS")) {
               
                if ((solverOptions = findOptions(tokenizer)) != null) {
                    System.out.println("SOLVER_OPTIONS:  " + solverOptions);
                }
                else {
                    error();
                }
            }
            else if (type.equalsIgnoreCase("GROUNDER_OPTIONS")) {
                if ((grounderOptions = findOptions(tokenizer)) != null) {
                    System.out.println("GROUNDER_OPTIONS:  " + grounderOptions);
                }
                else {
                    error();
                }
            }
            else {
                error();
            }    
        } 
        else {
            error();
        }
    }
   
    private void buildEngine(StringBuffer sb) {
        try {
            EngineRunner engine;
            if (!solverOk) {
                System.out.println("Solver not set");
            } 
            else {
                if (grounderOk) {
                    engine = new EngineRunner(solver,grounder);
                }
                else {
                    engine = new EngineRunner(solver);
                }
                
                Program program = new Program();
                program.addRule(sb.toString());
                program.end();
                engine.loadProgram(program);
                engine.setOutputConsole(true);
                engine.setOS(os);
                engine.compute();    
                System.out.println();
                System.out.println("--------------------------------------------------");
                System.out.println("NEW to write new program");
                System.out.println("UP to exit environment");
                System.out.println("or continue to add facts/rules to current program");
                System.out.println();
                System.out.println("--------------------------------------------------");
            }
        } 
        catch(JASPException jasp) {
            jasp.printStackTrace();
        }
    }

    private void error() {
        System.out.println("Unknown command");
    }
   
    private void clear() {
        for (int i=0;i<100;i++) System.out.println();
    }
   
    private String findOptions(StringTokenizer tokenizer) {
        String optionsOk = null;
        StringBuffer sb = new StringBuffer();
        while(tokenizer.hasMoreElements()) {
            sb.append(" " + tokenizer.nextToken());
        }
        String options = sb.toString().trim();
        if (options.startsWith("\"") && (options.endsWith("\""))) {
            optionsOk = options.substring(1,options.length()-1); 
        }

        return optionsOk;
    }

    private void newCommand() {
        clear();    
        System.out.println("-------------------------------------------------------");
        System.out.println("Start environment: ");
        System.out.println("     type \"RUN\" to compute models");
        System.out.println("     type \"NEW\" to write a new program");
        System.out.println("     type \"UP\" to exit environment");
        System.out.println("-------------------------------------------------------");
    }
}
