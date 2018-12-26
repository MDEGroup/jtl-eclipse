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

/**
 * Utilities is an helper class with string facility
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */
 
public class Utilities {
    
    //List of encoding format
    public static final String US_ASCII   = "US-ASCII";
    public static final String ISO_8859_1 = "ISO-8859-1";
    public static final String UTF_8      = "UTF-8";
    public static final String UTF_16BE   = "UTF_16BE";
    public static final String UTF_16LE   = "UTF_16LE";
    public static final String UTF_16     = "UTF-16";
    
    
    public   Utilities() {
    }

    /**
     * Check if a string is composed by alphabetic and/or numeric character.
     * 
     * @param str String to parse
     * @return True is a string is composed by alphabetic and/or numeric character, otherwise false.
     */
    public static boolean isAlphaNumeric(String str) {
        boolean blnNumeric = false;
        boolean blnAlpha = false;
            
        char chr[] = null;
        if(str != null)
            chr = str.toCharArray();
        
        for (int i=0; i<chr.length; i++) {
            if(chr[i] >= '0' && chr[i] <= '9') {
                blnNumeric = true;
                break;
            }
        }
     
        for (int i=0; i<chr.length; i++) {
            if((chr[i] >= 'A' && chr[i] <= 'Z') || (chr[i] >= 'a' && chr[i] <= 'z')) {
                blnAlpha = true;
                break;
            }
        }
        return (blnNumeric || blnAlpha);
    }
}