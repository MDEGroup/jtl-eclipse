/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class AsptDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private ASPT.resource.aspt.debug.AsptDebugTarget debugTarget;
	
	private ASPT.resource.aspt.debug.AsptDebugCommunicationHelper communicationHelper = new ASPT.resource.aspt.debug.AsptDebugCommunicationHelper();
	
	public AsptDebugProxy(ASPT.resource.aspt.debug.AsptDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
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
		sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.EXIT);
	}
	
	public ASPT.resource.aspt.debug.AsptDebugMessage getStack() {
		return sendCommandAndRead(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		ASPT.resource.aspt.debug.AsptDebugMessage message = new ASPT.resource.aspt.debug.AsptDebugMessage(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		ASPT.resource.aspt.debug.AsptDebugMessage message = new ASPT.resource.aspt.debug.AsptDebugMessage(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		ASPT.resource.aspt.debug.AsptDebugMessage response = sendCommandAndRead(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		ASPT.resource.aspt.debug.AsptDebugMessage response = sendCommandAndRead(ASPT.resource.aspt.debug.EAsptDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		ASPT.resource.aspt.debug.AsptDebugVariable[] variables  = new ASPT.resource.aspt.debug.AsptDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = ASPT.resource.aspt.util.AsptStringUtil.convertFromString(varString);
			
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
			org.eclipse.debug.core.model.IValue value = new ASPT.resource.aspt.debug.AsptDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			ASPT.resource.aspt.debug.AsptDebugVariable variable = new ASPT.resource.aspt.debug.AsptDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(ASPT.resource.aspt.debug.EAsptDebugMessageTypes command, String... parameters) {
		ASPT.resource.aspt.debug.AsptDebugMessage message = new ASPT.resource.aspt.debug.AsptDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private ASPT.resource.aspt.debug.AsptDebugMessage sendCommandAndRead(ASPT.resource.aspt.debug.EAsptDebugMessageTypes command, String... parameters) {
		ASPT.resource.aspt.debug.AsptDebugMessage message = new ASPT.resource.aspt.debug.AsptDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
