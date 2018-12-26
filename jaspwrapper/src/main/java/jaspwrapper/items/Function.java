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

import java.util.ArrayList;


/**
 * Function class describes a function in logic language
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class Function extends Term {

    private ArrayList <Term> arguments;
    private String name;

    /**
     * Creates a function object
     * 
     * @param name Function name
     */
    public Function (String name) {
        this.name = name;
        arguments = new ArrayList <Term> ();
    }
    
    /**
     * Add a term in function
     * 
     * @param term Term to add
     */
    public void addTerm(Term term) {
        if (term == null) throw new NullPointerException();
        arguments.add(term);
    }
    
    /**
     * Remove a term in function
     * 
     * @param term Term to remove
     */
    public void removeTerm(Term term){
        if (term == null) throw new NullPointerException();
        arguments.remove(term);
    }
    
    /**
     * Returns number of arguments
     * 
     * @return Number of arguments
     */
    
    public int getArity() {
        return arguments.size();
    }
    
    /**
     * Returns function as string
     *  
     * @return Function as string
     */
    
    public String toString() {
        
        StringBuffer  sb = new StringBuffer();
        int counter = 0;
        for (Term item : arguments) {
            counter++;            
            sb.append(item.toString());
                sb.append(",");
             
        }
        
        //remove last comma 
        String arguments = sb.toString();
        arguments = arguments.substring(0,arguments.length()-1);
         
         return name + "("+ arguments + ")";
    }
    
}
