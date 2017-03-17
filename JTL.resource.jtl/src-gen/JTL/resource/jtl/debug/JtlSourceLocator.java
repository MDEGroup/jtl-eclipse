/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.debug;

public class JtlSourceLocator extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant[]{new JTL.resource.jtl.debug.JtlSourceLookupParticipant()});
	}
	
}
