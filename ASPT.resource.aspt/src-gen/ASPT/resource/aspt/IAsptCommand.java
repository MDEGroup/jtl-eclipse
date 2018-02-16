/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IAsptCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
