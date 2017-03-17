/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IAspmmCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
