/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class AspDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private ASP.resource.asp.debug.AspDebugTarget debugTarget;
	
	private ASP.resource.asp.debug.AspDebugCommunicationHelper communicationHelper = new ASP.resource.asp.debug.AspDebugCommunicationHelper();
	
	public AspDebugProxy(ASP.resource.asp.debug.AspDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
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
		sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes.EXIT);
	}
	
	public ASP.resource.asp.debug.AspDebugMessage getStack() {
		return sendCommandAndRead(ASP.resource.asp.debug.EAspDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		ASP.resource.asp.debug.AspDebugMessage message = new ASP.resource.asp.debug.AspDebugMessage(ASP.resource.asp.debug.EAspDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		ASP.resource.asp.debug.AspDebugMessage message = new ASP.resource.asp.debug.AspDebugMessage(ASP.resource.asp.debug.EAspDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		ASP.resource.asp.debug.AspDebugMessage response = sendCommandAndRead(ASP.resource.asp.debug.EAspDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		ASP.resource.asp.debug.AspDebugMessage response = sendCommandAndRead(ASP.resource.asp.debug.EAspDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		ASP.resource.asp.debug.AspDebugVariable[] variables  = new ASP.resource.asp.debug.AspDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = ASP.resource.asp.util.AspStringUtil.convertFromString(varString);
			
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
			org.eclipse.debug.core.model.IValue value = new ASP.resource.asp.debug.AspDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			ASP.resource.asp.debug.AspDebugVariable variable = new ASP.resource.asp.debug.AspDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(ASP.resource.asp.debug.EAspDebugMessageTypes command, String... parameters) {
		ASP.resource.asp.debug.AspDebugMessage message = new ASP.resource.asp.debug.AspDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private ASP.resource.asp.debug.AspDebugMessage sendCommandAndRead(ASP.resource.asp.debug.EAspDebugMessageTypes command, String... parameters) {
		ASP.resource.asp.debug.AspDebugMessage message = new ASP.resource.asp.debug.AspDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
