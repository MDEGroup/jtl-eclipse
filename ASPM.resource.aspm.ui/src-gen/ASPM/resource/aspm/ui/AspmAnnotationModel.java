/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public AspmAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new ASPM.resource.aspm.ui.AspmMarkerAnnotation(marker);
	}
	
}
