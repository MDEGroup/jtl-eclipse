/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class AsptDebugMessage {
	
	private static final char DELIMITER = ':';
	private ASPT.resource.aspt.debug.EAsptDebugMessageTypes messageType;
	private String[] arguments;
	
	public AsptDebugMessage(ASPT.resource.aspt.debug.EAsptDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public AsptDebugMessage(ASPT.resource.aspt.debug.EAsptDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public ASPT.resource.aspt.debug.EAsptDebugMessageTypes getMessageType() {
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
		return ASPT.resource.aspt.util.AsptStringUtil.encode(DELIMITER, parts);
	}
	
	public static AsptDebugMessage deserialize(String response) {
		java.util.List<String> parts = ASPT.resource.aspt.util.AsptStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		ASPT.resource.aspt.debug.EAsptDebugMessageTypes type = ASPT.resource.aspt.debug.EAsptDebugMessageTypes.valueOf(messageType);
		AsptDebugMessage message = new AsptDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(ASPT.resource.aspt.debug.EAsptDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + ASPT.resource.aspt.util.AsptStringUtil.explode(arguments, ", ") + "]";
	}
	
}
