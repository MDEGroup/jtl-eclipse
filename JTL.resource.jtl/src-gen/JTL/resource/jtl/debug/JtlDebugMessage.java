/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class JtlDebugMessage {
	
	private static final char DELIMITER = ':';
	private JTL.resource.jtl.debug.EJtlDebugMessageTypes messageType;
	private String[] arguments;
	
	public JtlDebugMessage(JTL.resource.jtl.debug.EJtlDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public JtlDebugMessage(JTL.resource.jtl.debug.EJtlDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public JTL.resource.jtl.debug.EJtlDebugMessageTypes getMessageType() {
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
		return JTL.resource.jtl.util.JtlStringUtil.encode(DELIMITER, parts);
	}
	
	public static JtlDebugMessage deserialize(String response) {
		java.util.List<String> parts = JTL.resource.jtl.util.JtlStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		JTL.resource.jtl.debug.EJtlDebugMessageTypes type = JTL.resource.jtl.debug.EJtlDebugMessageTypes.valueOf(messageType);
		JtlDebugMessage message = new JtlDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(JTL.resource.jtl.debug.EJtlDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + JTL.resource.jtl.util.JtlStringUtil.explode(arguments, ", ") + "]";
	}
	
}
