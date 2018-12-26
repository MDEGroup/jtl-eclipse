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


package jaspwrapper.output;

import jaspwrapper.items.Atom;
import jaspwrapper.items.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Iterator;


/**
 * LatexOutputResult - output results in latex format
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class LatexOutputResult implements OutputResult{

    private int numberModels;
    private String filename;
    private FileWriter fstream;
    private BufferedWriter out;
    private boolean firstAccess;
   
    public LatexOutputResult(String filename) {
        if (filename == null) throw new IllegalArgumentException("filename must be not null");
        this.filename = filename;
        numberModels= 0;
        firstAccess = true;
        try {
            fstream = new FileWriter(filename);
            out = new BufferedWriter(fstream);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    

    public void onStartEvent() {
        try {

             out.write("\\documentclass[a4paper,11pt]{article}\r\n");
             out.write("\\usepackage[latin1]{inputenc}\r\n");
             out.write("\\usepackage[italian]{babel}\r\n");
             out.write("\\begin{document}\r\n");
         } catch (IOException e) {
             e.printStackTrace();
         }    
    }

    public void onNewModelEvent(Model model) {
        numberModels++;
        
        try {
            if (firstAccess) {
                StringBuffer sb = new StringBuffer();
                // set columns number and format
                for (int i = 0; i< model.getNumberAtoms(); i ++) {
                    sb.append("c");
                }
                out.write("\\begin{tabular}{" + sb.toString() + "}" + "\r\n");
                firstAccess = false;
            }
            
            StringBuffer sb2 = new StringBuffer();
            for (Iterator iterator = model.iterator(); iterator.hasNext();) {
                Atom atom = (Atom) iterator.next();
                sb2.append(atom.toString());
                sb2.append(" & ");
            }
            String tmp = null;
            tmp = sb2.toString();
            // remove last &
            tmp = tmp.substring(0,tmp.length() - 3);
            out.write(tmp + " \\\\\r\n");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onEndEvent() {
       try {
            out.write("\\end{tabular}\r\n");
            out.write("\\end{document}");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}