/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class AspmmDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private ASPMM.resource.aspmm.debug.AspmmDebugTarget debugTarget;
	
	private ASPMM.resource.aspmm.debug.AspmmDebugCommunicationHelper communicationHelper = new ASPMM.resource.aspmm.debug.AspmmDebugCommunicationHelper();
	
	public AspmmDebugProxy(ASPMM.resource.aspmm.debug.AspmmDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.EXIT);
	}
	
	public ASPMM.resource.aspmm.debug.AspmmDebugMessage getStack() {
		return sendCommandAndRead(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage message = new ASPMM.resource.aspmm.debug.AspmmDebugMessage(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage message = new ASPMM.resource.aspmm.debug.AspmmDebugMessage(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage response = sendCommandAndRead(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage response = sendCommandAndRead(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		ASPMM.resource.aspmm.debug.AspmmDebugVariable[] variables  = new ASPMM.resource.aspmm.debug.AspmmDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = ASPMM.resource.aspmm.util.AspmmStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new ASPMM.resource.aspmm.debug.AspmmDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			ASPMM.resource.aspmm.debug.AspmmDebugVariable variable = new ASPMM.resource.aspmm.debug.AspmmDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes command, String... parameters) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage message = new ASPMM.resource.aspmm.debug.AspmmDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private ASPMM.resource.aspmm.debug.AspmmDebugMessage sendCommandAndRead(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes command, String... parameters) {
		ASPMM.resource.aspmm.debug.AspmmDebugMessage message = new ASPMM.resource.aspmm.debug.AspmmDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
