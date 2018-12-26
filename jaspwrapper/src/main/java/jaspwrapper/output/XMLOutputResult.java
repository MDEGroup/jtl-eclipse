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

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import java.util.Iterator;


/**
 * XMLOutputResult - output results in xml format
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class XMLOutputResult implements OutputResult{

    private String filename;
    private String encoding;
    private OutputStream fout; 
    private OutputStream bout; 
    private OutputStreamWriter out;  
    private int numberModels;
    

    public XMLOutputResult(String filename) {
        if (filename == null) throw new IllegalArgumentException("filename argument must be not null");
        
        this.filename = filename;
        encoding = "ISO-8859-1"; //default
        numberModels = 0;
        
        try {
            fout = new FileOutputStream(filename);
            bout = new BufferedOutputStream(fout);
            out = new OutputStreamWriter(bout,encoding);
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.exit(0);
        }
        catch(UnsupportedEncodingException uee) {
            uee.printStackTrace();
            System.exit(0);
        }
    }
    
    public XMLOutputResult(String filename, String encoding) {
        this(filename);
        if (encoding == null) throw new IllegalArgumentException("encoding argument must be not null");
        this.encoding = encoding; 
    }

    public void onStartEvent() {
        try {
            out.write("<?xml version=\"1.0\" ");
            out.write("encoding=\""+encoding+"\"?>\r\n");  
            out.write("<jaspwrapper>\r\n"); 
            out.write("\t<output>\r\n"); 
            out.write("\t\t<models>\r\n");
                
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    
    public void onNewModelEvent(Model model) {
        if (model == null) throw new NullPointerException ("model null");
        try {
            numberModels++;
            out.write("\t\t\t<model atoms=\""+model.getNumberAtoms()+"\">\r\n");
            
            for(Iterator modelIterator = model.iterator(); modelIterator.hasNext();) {
                Atom atom = (Atom) modelIterator.next();
    
                out.write("\t\t\t\t<atom name=\""+ atom.getName() +"\" arity=\""+atom.getArity()+"\">\r\n");
                int index = 0;
                for(Iterator atomIterator = atom.iterator(); atomIterator.hasNext();) {
                    index++;
                    Constant constant = (Constant) atomIterator.next();
                    out.write("\t\t\t\t\t<argument index=\""+ index +"\" value=\""+ constant + "\"/>\r\n");
                }
                
                out.write("\t\t\t\t</atom>\r\n");
            }
            
            out.write("\t\t\t</model>\r\n");
            
        } 
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }



    public  void onEndEvent() {
        try {
            out.write("\t\t\t<total>\r\n");
            out.write("\t\t\t"+ numberModels + "\r\n");
            out.write("\t\t\t</total>\r\n");

            out.write("\t\t</models>\r\n");
            out.write("\t</output>\r\n"); 
            out.write("</jaspwrapper>\r\n"); 
            out.flush();  // Don't forget to flush!
            out.close();
                
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
    }
    
    public String getFilename() {
        return filename;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }




}
