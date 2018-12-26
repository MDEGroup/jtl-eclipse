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
 * HTMLOutputResult - output results in a html page
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class HTMLOutputResult implements OutputResult{

    private int numberModels;
    private String filename;
    private FileWriter fstream;
    private BufferedWriter out;
   
    public HTMLOutputResult(String filename) {
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
    

    public void onStartEvent() {
        try {
        
            out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
            out.write("<HTML>\r\n");
            out.write("<HEAD>\r\n");
            out.write("<TITLE> JASPWrapper HTML Output Result </TITLE>\r\n");
            out.write("<META NAME=\"Generator\" CONTENT=\"JASPWrapper\">\r\n");
            out.write("<META NAME=\"Author\" CONTENT=\"Giovanni Pirrotta\">\r\n");
            out.write("<META NAME=\"Keywords\" CONTENT=\"JASPWrapper, answer set programming, smodels, Giovanni Pirrotta\">\r\n");
            out.write("<META NAME=\"Description\" CONTENT=\"JASPWrapper - HTML Output Result\">\r\n");
            out.write("<STYLE TYPE=\"TEXT/CSS\">\r\n");
            out.write("\tBODY {\r\n");
            out.write("\t\tFONT-FAMILY: VERDANA, ARIAL, HELVETICA, SANS-SERIF;\r\n");
            out.write("\t\tFONT-SIZE: 9pt;\r\n");
            out.write("\t\tCOLOR: #FFFF99;\r\n");
            out.write("\t\tBACKGROUND-COLOR: #336633;\r\n");
            out.write("\t}\r\n");
            out.write("</STYLE>\r\n");
            out.write("</HEAD>\r\n");
            out.write("<BODY>\r\n");
            out.write("\t<H3>JASPWrapper - HTML Output Result</H3>\r\n");
            out.write("\t<H4>Models:</H4>\r\n");
            out.write("\t<TABLE BORDER=\"0\">\r\n");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void onNewModelEvent(Model model) {
        numberModels++;
        try {
            
            out.write("\t\t<TR>");
            
            for(Iterator iterator = model.iterator(); iterator.hasNext();) {
                Atom atom = (Atom) iterator.next();
                out.write("<TD>");
                out.write(atom.toString());
                out.write("</TD>");
            }
            
            out.write("</TR>\r\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onEndEvent() {
       try {
            out.write("\t</TABLE>\r\n");
            out.write("\t<H3> Total models: " + numberModels + "</H3>\r\n");
            out.write("</BODY>\r\n");
            out.write("</HTML>\r\n");
            
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
