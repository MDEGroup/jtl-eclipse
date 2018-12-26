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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Model class
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class Model {

    private List <Atom> atoms;
    private StringBuffer sb;
    
    /**
     * Builds a model object
     */
    public Model() {
        atoms = new LinkedList <Atom>();
    }

    /**
     * Adds an atom in the model
     * @param atom Atom to add
     */
    public void addAtom(Atom atom) {
        atoms.add(atom);
    }
    
    /**
     * Removes atom from model
     * @param atom Atom to remove
     */
    public void removeAtom(Atom atom) {
        atoms.remove(atom);
    }

    /**
     * Atom as string
     * @return Atom in string format
     */
    public String toString() {
        sb = null;
        sb = new StringBuffer();
        
        for (Iterator iterator = atoms.iterator(); iterator.hasNext();) {
            Atom atom = (Atom) iterator.next();
            sb.append(atom.toString()+" ");
        }
        
        return sb.toString().trim();
    }

    /**
     * Returns number of atoms
     * @return Number of atoms
     */
    public int getNumberAtoms() {
        return atoms.size();
    }
    
    /**
     * Returns atoms iterator
     * @return Atoms iterator
     */
    public Iterator <Atom> iterator() {
        return atoms.iterator();
    }

}
