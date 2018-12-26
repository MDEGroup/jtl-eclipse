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

 /**
  * Literal class describes an atom <code>a</code> or its explicit negation <code>-a</code>
  * 
  * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
  * @version 0.9
  * @since Java 5.0
  */
public class Literal {
    
    private Atom atom;
    private boolean explicitNegation;
    
    /**
     * Builds a literal object
     * 
     * @param atom An atom object
     */
    public Literal(Atom atom) {
        this.atom = atom;
        explicitNegation = false;
    }
    
    /**
     * Builds a literal object
     * 
     * @param atom An atom object
     * @param explicitNegation Truth of negation (i.e. -a)
     */
    public Literal(Atom atom, boolean explicitNegation ) {
        this.atom = atom;
        this.explicitNegation = explicitNegation;
    }
    
    /**
     * Returns truth as string
     * @return Truth as string
     */
    private String getStringExplicitNegation() {
        return (explicitNegation) ? "-" : "";
    }
    
    /**
     * Returns literal as string
     * @return Literal as string
     */
    public String toString() {
        return getStringExplicitNegation() + "" + atom.toString();
    }

    /**
     * Tests if atom is explicitly negated.
     * @return true is atom is explicitly negated, otherwise false
     */
    public boolean isExplicitNegation() {
        return explicitNegation;
    }
}
