/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.debug;

public class AsptSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof ASPT.resource.aspt.debug.AsptStackFrame) {
			ASPT.resource.aspt.debug.AsptStackFrame frame = (ASPT.resource.aspt.debug.AsptStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
