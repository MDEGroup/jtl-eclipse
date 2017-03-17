/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IAspCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
