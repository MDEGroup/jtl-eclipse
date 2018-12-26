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


package jaspwrapper.util;

import java.util.Date;


/**
 * Timer utility
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */

public class Timer {        
    public long start;
    public long stop;
    
    public Timer() {
        reset();
    }
    
    /**
     * Starts timer
     */
    public void start() {	
        Date startTime = new Date();
        start = startTime.getTime();
    }
    
    /**
     * Stop timer
     */
    public void stop() {
        Date stopTime = new Date();	
        stop = stopTime.getTime();
    }
      
    /**
     * Reset timer
     */
    void reset() {
        start = 0;
        stop  = 0;
     }                
    
    /**
     * Returns elapsed time
     * 
     * @return Elapsed time in milliseconds
     */
    public long getElapsed() {
        return stop-start;
    }
}