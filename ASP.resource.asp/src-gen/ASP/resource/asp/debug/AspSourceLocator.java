/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.debug;

public class AspSourceLocator extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant[]{new ASP.resource.asp.debug.AspSourceLookupParticipant()});
	}
	
}
