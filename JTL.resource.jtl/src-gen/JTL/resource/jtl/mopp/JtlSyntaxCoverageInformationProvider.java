/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			JTL.JTL.JTLPackage.eINSTANCE.getTransformation(),
			JTL.JTL.JTLPackage.eINSTANCE.getModel(),
			JTL.JTL.JTLPackage.eINSTANCE.getRelation(),
			JTL.JTL.JTLPackage.eINSTANCE.getDomain(),
			JTL.JTL.JTLPackage.eINSTANCE.getPattern(),
			JTL.JTL.JTLPackage.eINSTANCE.getWhen(),
			JTL.JTL.JTLPackage.eINSTANCE.getWhere(),
			JTL.JTL.JTLPackage.eINSTANCE.getPredicate(),
			JTL.template.TemplatePackage.eINSTANCE.getObjectTemplateExp(),
			JTL.imperativeocl.ImperativeoclPackage.eINSTANCE.getAssignExp(),
			JTL.essentialocl.EssentialoclPackage.eINSTANCE.getOperationCallExp(),
			JTL.essentialocl.EssentialoclPackage.eINSTANCE.getBooleanLiteralExp(),
			JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariableExp(),
			JTL.essentialocl.EssentialoclPackage.eINSTANCE.getStringLiteralExp(),
			JTL.essentialocl.EssentialoclPackage.eINSTANCE.getVariable(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			JTL.JTL.JTLPackage.eINSTANCE.getTransformation(),
		};
	}
	
}
