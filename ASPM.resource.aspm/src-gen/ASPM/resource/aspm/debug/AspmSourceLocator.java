/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.debug;

public class AspmSourceLocator extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant[]{new ASPM.resource.aspm.debug.AspmSourceLookupParticipant()});
	}
	
}
