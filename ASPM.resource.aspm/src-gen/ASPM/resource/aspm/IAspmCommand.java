/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IAspmCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
