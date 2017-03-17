/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.grammar;

public class JtlContainment extends JTL.resource.jtl.grammar.JtlTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public JtlContainment(org.eclipse.emf.ecore.EStructuralFeature feature, JTL.resource.jtl.grammar.JtlCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = JTL.resource.jtl.util.JtlStringUtil.explode(allowedTypes, ", ", new JTL.resource.jtl.IJtlFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
