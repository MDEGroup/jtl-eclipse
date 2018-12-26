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


package jaspwrapper.items;

import jaspwrapper.exception.JASPException;

import jaspwrapper.util.Utilities;


/**
 * Variable class describes a variable in the logic language. A variable is a string of letters and numbers
 * starting with an upper case letter.
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class Variable extends Term {
    
    private String name;
    
   
    /**
     * Builds a variable object.
     * 
     * @param name Name of Variable
     * @throws JASPException If not start with uppercase or is not alphanumeric or alphabetic
     */
    public Variable(String name) throws JASPException {
        
        if (!Character.isUpperCase(name.charAt(0)) && !(Utilities.isAlphaNumeric(name))) {
            throw new JASPException("Variable starts with uppercase and must be alphabetic or alphanumeric");
        }
        this.name = name;   
    }    

    /**
     * Returns variable as string
     * @return Variable as string
     */
    public String toString() {
        return name;
    }

}
