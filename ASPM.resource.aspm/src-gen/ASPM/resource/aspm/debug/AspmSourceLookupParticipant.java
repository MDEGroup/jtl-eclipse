/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.debug;

public class AspmSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof ASPM.resource.aspm.debug.AspmStackFrame) {
			ASPM.resource.aspm.debug.AspmStackFrame frame = (ASPM.resource.aspm.debug.AspmStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
