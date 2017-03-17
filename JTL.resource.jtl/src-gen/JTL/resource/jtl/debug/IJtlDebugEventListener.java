/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.debug;

public interface IJtlDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(JTL.resource.jtl.debug.JtlDebugMessage message);
}
