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

import jaspwrapper.exception.JASPException;

import jaspwrapper.items.Atom;
import jaspwrapper.items.Constant;
import jaspwrapper.items.Literal;
import jaspwrapper.items.Rule;

import jaspwrapper.items.Variable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;


/**
 * Program class defines what you need to compute.
 * <br><br>
 * Example 1 - programming with grammar object
 * <PRE>
 *      Variable x = new Variable("X");
 *      Constant tweety = new Constant("tweety");
 *      Constant skippy = new Constant("skippy");
 *      Atom bird = new Atom("bird");
 *      bird.addTerm(x);
 *      Atom abnormal = new Atom("abnormal");
 *      abnormal.addTerm(x);
 *      Atom penguin = new Atom("penguin");
 *      penguin.addTerm(x);
 *      Atom bird1 = new Atom ("bird");
 *      bird1.addTerm(tweety);
 *      Atom penguin1 = new Atom("penguin");
 *      penguin1.addTerm(skippy);
 *      Atom flies = new Atom("flies");
 *      flies.addTerm(x);
 *      Rule rule1 = new Rule();
 *      rule1.addToHead(new Literal(flies));
 *      rule1.addToPosBody(new Literal(bird));
 *      rule1.addToNegBody(new Literal (abnormal));
 *      Rule rule2 = new Rule();
 *      rule2.addToHead(new Literal(abnormal));
 *      rule2.addToPosBody(new Literal(penguin));
 *      Rule rule3 = new Rule();
 *      rule3.addToHead(new Literal(bird));
 *      rule3.addToPosBody(new Literal(penguin));
 *      Literal lit1 = new Literal(bird1);
 *      Literal lit2 = new Literal(penguin1);
 *      <BR>
 *      Program p1 = new Program();
 *      p1.addRule(rule1);
 *      p1.addRule(rule2);
 *      p1.addRule(rule3);
 *      p1.addFact(lit1);
 *      p1.addFact(lit2);
 *      p1.end();
 *  </PRE>
 *Example 2 - Type program as string <br>
 * <PRE>
 *      Program p2 = new Program();
 *      p2.addRule("a:-not b.");
 *      p2.addRule("b:-not a.");
 *      p2.addRule("c:-not d.");
 *      p2.addRule("d:-not c.");
 *      p2.addRule("e:-not f.");
 *      p2.addRule("f:-not e.");
 *      p2.end();
 *</PRE>
 *
 * Example 3 - Loading source file
 * <PRE>
 *      Program p3 = new Program();
 *      p3.addFromFile("d:\\queens.sm");
 *      p3.end();
 * </PRE>
 *
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */


public class Program {

    private final String TEMP_FILE = "jaspwrapper"  ;



    private ArrayList <String> inputFiles;
    private StringBuffer srcProgram;
    private boolean finished;

     /**
      * Builds an instance of Program
      */
     public Program() {
        inputFiles = new ArrayList<String>();
        srcProgram = new StringBuffer();
        finished = false;
    }

    /**
     * Adds a fact in the program
     *
     * @param literal An Iliteral object
     */
    public void addFact(Literal literal) {
        srcProgram.append(literal.toString() + ".\n");
    }


    /**
     * Adds a fact in the program
     *
     * @param fact A String object
     */
    public void addFact(String fact) {
        srcProgram.append(fact);
    }

    /**
     * Adds a rule in the program
     *
     * @param rule A Rule object
     */
    public void addRule(Rule rule) {
        srcProgram.append(rule.toString() + ".\n");
    }

   /**
     * Adds a rule in the program
     *
     * @param rule A String object
     */
    public void addRule(String rule) {
        srcProgram.append(rule);
    }

    /**
     * Loads file in the program
     * @param file File to load
     * @throws JASPException If file not found
     */
    public void addFromFile(String file) throws JASPException {

        File f = new File(file);
        if (!f.exists()) {
            throw new JASPException("File not found");
        }
        inputFiles.add(file);
    }

    /**
     * End of program
     */
    public void end() {
        // se srcProgram non e' vuoto, allora i programmi sono on fly, altrimenti sono da file
        if (srcProgram.length() != 0) {
            createTempFile();
        }
        finished = true ;
    }

    // crea il file temporaneo del programma on-fly
    /**
     * Creates temporary file
     *
     * @return Temporary File
     */
    private File createTempFile() {
        File temp = null;
        try {
            // Create temp file.
            temp = File.createTempFile(TEMP_FILE, null);
            // Delete temp file when program exits.
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write(srcProgram.toString());
            inputFiles.add(temp.getAbsolutePath());
            out.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return temp;
    }

    /**
     * Gets loaded files in the program
     * @return Loaded files
     */
    public   ArrayList <String>  getLoadedFiles() {
        return (ArrayList <String>) inputFiles.clone();
    }

    /**
     * Returns program as string
     *
     * @return Program as string
     */
    @Override
	public String toString() {
        return srcProgram.toString();
    }

    /**
     * Return true is end method is been invoked
     *
     * @return true if end method is been invoked
     */
    public boolean endProgram() {
        return finished;
    }

}
