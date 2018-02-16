/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.grammar;

public class AsptContainment extends ASPT.resource.aspt.grammar.AsptTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public AsptContainment(org.eclipse.emf.ecore.EStructuralFeature feature, ASPT.resource.aspt.grammar.AsptCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = ASPT.resource.aspt.util.AsptStringUtil.explode(allowedTypes, ", ", new ASPT.resource.aspt.IAsptFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
