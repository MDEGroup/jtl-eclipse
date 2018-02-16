/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public class AsptHoverTextProvider implements ASPT.resource.aspt.IAsptHoverTextProvider {
	
	private ASPT.resource.aspt.ui.AsptDefaultHoverTextProvider defaultProvider = new ASPT.resource.aspt.ui.AsptDefaultHoverTextProvider();
	
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
