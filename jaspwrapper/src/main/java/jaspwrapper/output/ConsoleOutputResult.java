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
 * ConsoleOutputResult - output results in console
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class ConsoleOutputResult implements OutputResult{

 
    private int numberModels;
    

    public ConsoleOutputResult() {
        numberModels= 0;
    }
    

    public void onStartEvent() {
        System.out.println("JASPWrapper - Result by Console");
    }

    
    public void onNewModelEvent(Model model) {
        if (model == null) throw new NullPointerException ("model null");
        System.out.println(model);
        numberModels++;
    }



    public void onEndEvent() {
        System.out.println("Total models:" + numberModels);
    }
    
}