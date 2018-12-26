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

package jaspwrapper.analyzer;

import jaspwrapper.exec.EngineRunner;

import jaspwrapper.items.Model;

import java.io.InputStream;


/**
 * Analyzer interface - each concrete analyzer must implement this interface.
 * 
 * @author <a href="mailto:gpirrotta@unime.it">Giovanni Pirrotta</a>
 * @version 0.9
 * @since Java 5.0
 */


public abstract class OutputAnalyzer {
    public abstract void analyze(EngineRunner engine, int mode, int source, InputStream is);
    
    public void addModel(EngineRunner engine, Model model) {
        engine.addModel(model);
    }
    
    public void setErrorMessage(EngineRunner engine, String string) {
        engine.appendErrorMessage(string);
    }
}