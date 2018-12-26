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


/**
 * Solver class describes solver configuration.
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class Solver  {

    private String exec ;
    private String options;
    

    private Solver() {
        options = "";
     }
    
    /**
     * Builds an instance of Solver configuration
     * @param exec pathname of solver executable (i.e. c:\\windows\\programs\\smodels.exe for windows)
     */      
   
    public Solver(String exec) {
        this();
        if (exec == null) throw new IllegalArgumentException ("Invalid argument");
        this.exec = exec;
     }
    
    
    /**
      * Sets options for solver
      * 
      * @param options Options for solver
      */
    
     public void setOptions(String options) {
        if (options == null) throw new IllegalArgumentException("solver options null");
        if (options.trim() != "") {
            this.options = options;   
        }
         
     }
     
     
     /**
      * Returns full line options
      * @return line options
      */
       public String getOptions() {
         return options;
     }


     /**
      * Gets solver executable name
      * @return Executable name
      */
     public String getExec() {
         return exec;
     }
    
}

