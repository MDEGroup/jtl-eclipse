/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			ASP.ASPPackage.eINSTANCE.getTransformation(),
			ASP.ASPPackage.eINSTANCE.getRelation(),
			ASP.ASPPackage.eINSTANCE.getLeftPattern(),
			ASP.ASPPackage.eINSTANCE.getRightPattern(),
			ASP.ASPPackage.eINSTANCE.getMetanode(),
			ASP.ASPPackage.eINSTANCE.getMetaprop(),
			ASP.ASPPackage.eINSTANCE.getMetaedge(),
			ASP.ASPPackage.eINSTANCE.getNode(),
			ASP.ASPPackage.eINSTANCE.getProp(),
			ASP.ASPPackage.eINSTANCE.getEdge(),
			ASP.ASPPackage.eINSTANCE.getNamedFunction(),
			ASP.ASPPackage.eINSTANCE.getRule(),
			ASP.ASPPackage.eINSTANCE.getConstraint(),
			ASP.ASPPackage.eINSTANCE.getLiteral(),
			ASP.ASPPackage.eINSTANCE.getTerminal(),
			ASP.ASPPackage.eINSTANCE.getNot(),
			ASP.ASPPackage.eINSTANCE.getEq(),
			ASP.ASPPackage.eINSTANCE.getNotEq(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			ASP.ASPPackage.eINSTANCE.getTransformation(),
		};
	}
	
}
