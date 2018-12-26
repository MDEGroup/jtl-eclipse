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
 * Constant class describes a constant in logic language. A costant is a string of letters and numbers
 * starting with a lower case letter.
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class Constant extends Term{
                
    String value;
    String name;

    
    /**
     * Builds a constant object.
     * 
     * @param name Name of Constant
     * @throws JASPException If not start with lowercase or is not alphanumeric
     */    
    public Constant(String name) throws JASPException{
        if (!Character.isLowerCase(name.charAt(0)) && !Utilities.isAlphaNumeric(name)) {
            throw new JASPException("Constant starts with lowercase and must be alphanumeric");
        }
        this.name = name;
        value = null;
    }
    
    /**
     * Builds a constant object.
     * 
     * @param name  Name of constant
     * @param value Value of constant
     * @throws JASPException If not start with lowercase or is not alphanumeric
     */
    
    public Constant(String name, String value) {
        this.name  = name;
        this.value = value;
    }
    
    
    /**
     * Returns constant as string
     * 
     * @return Constant as stirng
     */
    public String toString() {
        return name;
    }

    /**
     * Returns value of constant as string
     * 
     * @return Value of constant as string
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns name of constant as string
     * 
     * @return Name of constant as string
     */
    public String getName() {
        return name;
    }
}
