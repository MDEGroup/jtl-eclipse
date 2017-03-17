/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class AspmmDebugMessage {
	
	private static final char DELIMITER = ':';
	private ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes messageType;
	private String[] arguments;
	
	public AspmmDebugMessage(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public AspmmDebugMessage(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes getMessageType() {
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
		return ASPMM.resource.aspmm.util.AspmmStringUtil.encode(DELIMITER, parts);
	}
	
	public static AspmmDebugMessage deserialize(String response) {
		java.util.List<String> parts = ASPMM.resource.aspmm.util.AspmmStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes type = ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes.valueOf(messageType);
		AspmmDebugMessage message = new AspmmDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(ASPMM.resource.aspmm.debug.EAspmmDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + ASPMM.resource.aspmm.util.AspmmStringUtil.explode(arguments, ", ") + "]";
	}
	
}
