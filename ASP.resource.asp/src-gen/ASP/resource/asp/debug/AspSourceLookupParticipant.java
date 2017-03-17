/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.debug;

public class AspSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof ASP.resource.asp.debug.AspStackFrame) {
			ASP.resource.asp.debug.AspStackFrame frame = (ASP.resource.asp.debug.AspStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
