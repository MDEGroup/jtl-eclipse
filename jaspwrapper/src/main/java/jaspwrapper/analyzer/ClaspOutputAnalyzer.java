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

package jaspwrapper.analyzer;


import jaspwrapper.exception.JASPException;
import jaspwrapper.exec.EngineRunner;
import jaspwrapper.items.Atom;
import jaspwrapper.items.Constant;
import jaspwrapper.items.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Concrete analyzer class for model extraction with clasp-format.
 *
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */


public class ClaspOutputAnalyzer extends OutputAnalyzer {

    private InputStreamReader isr;
    private BufferedReader    br;
    private String            line;
    private Model model;
    private Atom              atom;
    private String[]          tmp;
    private String            name;



    /**
     * Default constructor
     */

    public ClaspOutputAnalyzer() {
    }

    /**
     * Starts analyzing process
     *
     * @param engine Engine
     * @param mode Synchronization mode
     * @param source Source of input stream
     * @param is Input stream
     *
     * @throws IOException
     * @throws JASPException
     */
    @Override
	public synchronized void analyze(EngineRunner engine, int mode, int source, InputStream is) {

        if (engine == null) throw new IllegalArgumentException("engine object null");
        if (is == null) throw new IllegalArgumentException("input stream object null");


        isr   = new InputStreamReader(is);
        br    = new BufferedReader(isr);
        line  = null;
        model = null;
        atom  = null;
        tmp   = null;
        name  = null;

        try {
            if (source == EngineRunner.INPUT_STREAM) {
                while ((line = br.readLine()) != null) {
                    if (line.startsWith("Answer"))  {
                        // each line one model
                        line = br.readLine();
                        model = new Model();
                        tmp = line.split(" ");
                        // checks all atoms in model
                        for (int i = 0 ;i<tmp.length; i++) {
                            // if atom has not arguments
                            if (!tmp[i].contains("(")) {
                                atom = new Atom(tmp[i].trim());
                            }
                            else {
                                //if atom has arguments
                                int start = tmp[i].indexOf("(");
                                int end   = tmp[i].lastIndexOf(")");
                                name = tmp[i].substring(0,start);
                                atom = new Atom(name);
                                String tmp1[] = tmp[i].substring(start+1,end).split(",");
                                for (String item: tmp1) {
                                    atom.addTerm(new Constant(item.trim()));
                                }
                            }
                            // adds atom in model
                            model.addAtom(atom);
                        }
                        // adds atom in engine
                        addModel(engine,model);
                    }
                }
                // End of while - weak-up engine
                engine.setStatus(EngineRunner.END);
            }
            // if error stream is not empty
            else if (source == EngineRunner.ERROR_STREAM) {
                StringBuffer sb = new StringBuffer();
                // read error message
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                // append message to engine
                if (sb.toString().trim().length() > 0) {
                    setErrorMessage(engine,sb.toString());
                }
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.exit(0);
        }
        catch (JASPException jaspex) {
            System.out.println(jaspex);
            System.exit(0);
        }
    }

}