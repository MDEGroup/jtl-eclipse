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
import java.util.Iterator;
import java.util.List;


/**
 * Atom class describes an atom in the logic language. An atom is a predicate symbol that is optionally followed
 * by a parenthesized list of terms.
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class Atom {

    private String name;
    private List <Term> arguments;
    private Iterator iterator;
    
    /**
     * Private constructor
     */
    private Atom() {
        arguments = new  ArrayList <Term> ();
        this.name="";
        iterator = null;
    }
    
    /**
     * Builds an atom
     * 
     * @param name Name of atom
     */
    public Atom(String name) {
        this();
        this.name = name;
    }

    /**
     * Adds a term as argument
     * 
     * @param term Term object to add
     */
    public void addTerm(Term term) {
        arguments.add(term);
    }

    /**
     * Removes a term from arguments
     * 
     * @param term Term to remove
     */
    public void removeTerm(Term term) {
        arguments.remove(term);
    }

    /**
     * Remove all arguments from atom
     */
    public void removeArguments() {
        arguments.clear();
    }
    


    
    /**
     * Gets arity of atom
     * 
     * @return Arity of atom (number of arguments)
     */
    public int getArity() {
        return arguments.size();
    }
    
    /**
     * Returns atom as string
     * 
     * @return Atom as string
     */
    public String toString() {
        if (arguments.size() != 0) {
            StringBuffer  tmp = new StringBuffer();
            for (Term item : arguments) {
                tmp.append(item.toString());
                tmp.append(",");
            }
            String arg = tmp.toString();
            arg = arg.substring(0,arg.length()-1);
            return name + "("+ arg + ")";
        } 
        else {
            return name;
        }
    }
    
    /**
     * Retuns list of arguments
     * @return List of arguments
     */
    public List <Term> getArguments() {
        return arguments;
    }
    /**
     * Returns iterator of arguments
     * @return iterator of arguments
     */

    public Iterator iterator() {
        return  arguments.iterator();
    }
    /**
     * Returns name of atom
     * @return Name of atom
     */
    
    public String getName() {
        return name;
    }
}
