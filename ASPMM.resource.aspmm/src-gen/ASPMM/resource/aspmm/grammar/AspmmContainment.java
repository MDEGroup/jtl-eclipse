/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.grammar;

public class AspmmContainment extends ASPMM.resource.aspmm.grammar.AspmmTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public AspmmContainment(org.eclipse.emf.ecore.EStructuralFeature feature, ASPMM.resource.aspmm.grammar.AspmmCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = ASPMM.resource.aspmm.util.AspmmStringUtil.explode(allowedTypes, ", ", new ASPMM.resource.aspmm.IAspmmFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
