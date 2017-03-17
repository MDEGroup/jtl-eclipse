/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class AspDebugMessage {
	
	private static final char DELIMITER = ':';
	private ASP.resource.asp.debug.EAspDebugMessageTypes messageType;
	private String[] arguments;
	
	public AspDebugMessage(ASP.resource.asp.debug.EAspDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public AspDebugMessage(ASP.resource.asp.debug.EAspDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public ASP.resource.asp.debug.EAspDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return ASP.resource.asp.util.AspStringUtil.encode(DELIMITER, parts);
	}
	
	public static AspDebugMessage deserialize(String response) {
		java.util.List<String> parts = ASP.resource.asp.util.AspStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		ASP.resource.asp.debug.EAspDebugMessageTypes type = ASP.resource.asp.debug.EAspDebugMessageTypes.valueOf(messageType);
		AspDebugMessage message = new AspDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(ASP.resource.asp.debug.EAspDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + ASP.resource.asp.util.AspStringUtil.explode(arguments, ", ") + "]";
	}
	
}
