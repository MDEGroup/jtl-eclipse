/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class AspmDebugMessage {
	
	private static final char DELIMITER = ':';
	private ASPM.resource.aspm.debug.EAspmDebugMessageTypes messageType;
	private String[] arguments;
	
	public AspmDebugMessage(ASPM.resource.aspm.debug.EAspmDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public AspmDebugMessage(ASPM.resource.aspm.debug.EAspmDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public ASPM.resource.aspm.debug.EAspmDebugMessageTypes getMessageType() {
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
		return ASPM.resource.aspm.util.AspmStringUtil.encode(DELIMITER, parts);
	}
	
	public static AspmDebugMessage deserialize(String response) {
		java.util.List<String> parts = ASPM.resource.aspm.util.AspmStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		ASPM.resource.aspm.debug.EAspmDebugMessageTypes type = ASPM.resource.aspm.debug.EAspmDebugMessageTypes.valueOf(messageType);
		AspmDebugMessage message = new AspmDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(ASPM.resource.aspm.debug.EAspmDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + ASPM.resource.aspm.util.AspmStringUtil.explode(arguments, ", ") + "]";
	}
	
}
