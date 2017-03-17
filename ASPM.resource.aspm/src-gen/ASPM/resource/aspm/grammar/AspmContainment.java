/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.grammar;

public class AspmContainment extends ASPM.resource.aspm.grammar.AspmTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public AspmContainment(org.eclipse.emf.ecore.EStructuralFeature feature, ASPM.resource.aspm.grammar.AspmCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = ASPM.resource.aspm.util.AspmStringUtil.explode(allowedTypes, ", ", new ASPM.resource.aspm.IAspmFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
