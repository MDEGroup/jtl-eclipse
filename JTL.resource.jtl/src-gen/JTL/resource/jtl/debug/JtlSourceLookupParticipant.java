/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.debug;

public class JtlSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof JTL.resource.jtl.debug.JtlStackFrame) {
			JTL.resource.jtl.debug.JtlStackFrame frame = (JTL.resource.jtl.debug.JtlStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
