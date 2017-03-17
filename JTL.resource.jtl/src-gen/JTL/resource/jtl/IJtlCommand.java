/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IJtlCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
