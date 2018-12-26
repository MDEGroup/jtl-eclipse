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
import jaspwrapper.items.Constant;
import jaspwrapper.items.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Iterator;


/**
 * SQLOutputResult - output results in sql script
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class SQLOutputResult implements OutputResult{

    private int numberModels;
    private String filename;
    private FileWriter fstream;
    private BufferedWriter out;
    private int idAtom;
    private int idArgument;
   
    public SQLOutputResult(String filename) {
        if (filename == null) throw new IllegalArgumentException("filename must be not null");
        this.filename = filename;
        numberModels= 0;
        idAtom = 0;
        idArgument = 0;
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
        
            out.write("// JASPWrapper - SQLOutputResult - script\r\n\r\n");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void onNewModelEvent(Model model) {
        numberModels++;
        try {
            
            out.write("INSERT INTO MODELS(ID,ATOMS) VALUES("+ numberModels+","+model.getNumberAtoms()+");\r\n");
            
            
            for(Iterator iterator = model.iterator(); iterator.hasNext();) {
                idAtom++;
                Atom atom = (Atom) iterator.next();
                out.write("INSERT INTO ATOMS(ID,ID_MODEL,NAME,ARITY) VALUES("+ idAtom +","+numberModels+",\""+atom.getName() + "\","+atom.getArity()+");\r\n");
                
                int index = 0;
                for(Iterator iteratorArguments = atom.iterator(); iteratorArguments.hasNext();) {
                    idArgument++;
                    index++;
                    Constant constant = (Constant) iteratorArguments.next();
                    out.write("INSERT INTO ARGUMENTS(ID,ID_ATOM,INDEX,VALUE) VALUES("+ idArgument +","+idAtom+","+index + ",\""+constant.getName()+"\");\r\n");
                }
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onEndEvent() {
       try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
