/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlHoverTextProvider implements JTL.resource.jtl.IJtlHoverTextProvider {
	
	private JTL.resource.jtl.ui.JtlDefaultHoverTextProvider defaultProvider = new JTL.resource.jtl.ui.JtlDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
