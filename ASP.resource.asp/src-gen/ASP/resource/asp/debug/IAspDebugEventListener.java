/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.debug;

public interface IAspDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(ASP.resource.asp.debug.AspDebugMessage message);
}
