/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.debug;

public class AspmmSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof ASPMM.resource.aspmm.debug.AspmmStackFrame) {
			ASPMM.resource.aspmm.debug.AspmmStackFrame frame = (ASPMM.resource.aspmm.debug.AspmmStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
