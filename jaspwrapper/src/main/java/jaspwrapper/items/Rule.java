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

import java.util.ArrayList;
import java.util.List;


/**
 * Rule class describes a rule in the logic language
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class Rule {

    private List <Literal>  head;
    private List <Literal>  positiveBody;
    private List <Literal>  negativeBody;
    
    /**
     * Builds a rule
     */
    
    public Rule() {
        head = new ArrayList <Literal> ();
        positiveBody = new ArrayList <Literal> ();
        negativeBody = new ArrayList <Literal> ();
    }
    
   /**
     * Add literal in the head
     * 
     * @param literal Literal to add in the head
     */
    public void addToHead(Literal literal) throws JASPException {
        head.add(literal);
    }

    /**
     * Adds literal in the positive body
     * 
     * @param literal Literal to add in the positive body
     */
    public void addToPosBody(Literal literal) {
        positiveBody.add(literal);
    }

    /**
     * Adds literal in the negative body (like NAF - negation as failure)
     * 
     * @param literal Literal to add in the negative body
     */
    public void addToNegBody(Literal literal) {
        negativeBody.add(literal);
    }

    
    /**
     * Remove literal from head
     */
    public void removeFromHead(Literal literal){
        head.remove(literal);
    }

    /**
     * Removes literal in the positive body
     * 
     * @param literal Removes literal in the positive body
     */
    public void removeFromPosBody(Literal literal) {
        positiveBody.remove(literal);
    }

    /**
     * Removes literal in the negative body
     * 
     * @param literal Removes literal in the negative body
     */
    public void removeFromNegBody(Literal literal) {
        negativeBody.remove(literal);
    }

    /**
     * Returns head as string
     * 
     * @return Head as string
     */
    public String getHead() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < head.size(); i++) {
            Literal literal = head.get(i);
            sb.append(literal.toString() + " v ");
        }
        String tmp = sb.toString();
        tmp = tmp.substring(0,tmp.length() - 2).trim();
        return tmp;
    }
    
    /**
     * Returns body as string
     * 
     * @return body as string
     */
     
    public String getBody() {        
        StringBuffer tmp = new StringBuffer();
        for (Literal o : positiveBody) {
            tmp.append(o.toString());
            tmp.append(",");
        }
        for (Literal o : negativeBody) {
            tmp.append(" not " + o.toString());
            tmp.append(",");
        }
        tmp.replace(tmp.length()-1,tmp.length(),"");
        return tmp.toString();
    }
  
    
    /**
     * Returns rule as string
     * 
     * @return Rule as string
     */
    public String toString() {
         if (head != null)
             return getHead() + " :- " + getBody();
         else
             return ":-" + getBody();
    } 
}   
