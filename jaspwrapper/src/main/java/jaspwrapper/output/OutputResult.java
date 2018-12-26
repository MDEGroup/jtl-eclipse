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

import jaspwrapper.items.Model;


/**
 * OutputResult - it needs to implement it to obtain output result
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public interface OutputResult {
    
    /**
     * This event fires when a new model is intercepted
     * @param model model intercepted
     */
    public abstract void onNewModelEvent(Model model);
    
    /**
     * This event fires when computation begins
     */
    public abstract void onStartEvent();
    
    /**
     * This event fires when computation ends
     */
    public abstract void onEndEvent();
}
