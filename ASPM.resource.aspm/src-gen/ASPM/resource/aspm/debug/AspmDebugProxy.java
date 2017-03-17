/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class AspmDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private ASPM.resource.aspm.debug.AspmDebugTarget debugTarget;
	
	private ASPM.resource.aspm.debug.AspmDebugCommunicationHelper communicationHelper = new ASPM.resource.aspm.debug.AspmDebugCommunicationHelper();
	
	public AspmDebugProxy(ASPM.resource.aspm.debug.AspmDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
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
		sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.EXIT);
	}
	
	public ASPM.resource.aspm.debug.AspmDebugMessage getStack() {
		return sendCommandAndRead(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		ASPM.resource.aspm.debug.AspmDebugMessage message = new ASPM.resource.aspm.debug.AspmDebugMessage(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		ASPM.resource.aspm.debug.AspmDebugMessage message = new ASPM.resource.aspm.debug.AspmDebugMessage(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		ASPM.resource.aspm.debug.AspmDebugMessage response = sendCommandAndRead(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		ASPM.resource.aspm.debug.AspmDebugMessage response = sendCommandAndRead(ASPM.resource.aspm.debug.EAspmDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		ASPM.resource.aspm.debug.AspmDebugVariable[] variables  = new ASPM.resource.aspm.debug.AspmDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = ASPM.resource.aspm.util.AspmStringUtil.convertFromString(varString);
			
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
			org.eclipse.debug.core.model.IValue value = new ASPM.resource.aspm.debug.AspmDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			ASPM.resource.aspm.debug.AspmDebugVariable variable = new ASPM.resource.aspm.debug.AspmDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(ASPM.resource.aspm.debug.EAspmDebugMessageTypes command, String... parameters) {
		ASPM.resource.aspm.debug.AspmDebugMessage message = new ASPM.resource.aspm.debug.AspmDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private ASPM.resource.aspm.debug.AspmDebugMessage sendCommandAndRead(ASPM.resource.aspm.debug.EAspmDebugMessageTypes command, String... parameters) {
		ASPM.resource.aspm.debug.AspmDebugMessage message = new ASPM.resource.aspm.debug.AspmDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
