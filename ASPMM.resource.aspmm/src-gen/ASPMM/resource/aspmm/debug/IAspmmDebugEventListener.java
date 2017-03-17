/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.debug;

public interface IAspmmDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(ASPMM.resource.aspmm.debug.AspmmDebugMessage message);
}
