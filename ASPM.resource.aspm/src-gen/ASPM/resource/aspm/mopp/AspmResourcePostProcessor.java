/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmResourcePostProcessor implements ASPM.resource.aspm.IAspmResourcePostProcessor {
	
	public void process(ASPM.resource.aspm.mopp.AspmResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
