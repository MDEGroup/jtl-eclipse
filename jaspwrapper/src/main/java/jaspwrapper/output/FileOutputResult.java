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

import jaspwrapper.items.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * FileOutputResult - output results in a flat file
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
 
public class FileOutputResult implements OutputResult{

    private int numberModels;
    private String filename;
    private FileWriter fstream;
    private BufferedWriter out;
   
    public FileOutputResult(String filename) {
        if (filename == null) throw new IllegalArgumentException("filename must be not null");
        this.filename = filename;
        numberModels= 0;
        try {
            fstream = new FileWriter(filename);
            out = new BufferedWriter(fstream);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    

    public void onStartEvent() {}

    
    public void onNewModelEvent(Model model) {
        numberModels++;
        try {
            out.write(model.toString() + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onEndEvent() {
       try {
            out.write("\r\n");
            out.write("Total models:" + numberModels);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
