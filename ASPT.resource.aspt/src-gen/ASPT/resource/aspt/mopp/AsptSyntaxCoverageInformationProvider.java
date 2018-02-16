/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			ASPT.ASPTPackage.eINSTANCE.getTraceModel(),
			ASPT.ASPTPackage.eINSTANCE.getTraceNode(),
			ASPT.ASPTPackage.eINSTANCE.getTraceProp(),
			ASPT.ASPTPackage.eINSTANCE.getTraceEdge(),
			ASPT.ASPTPackage.eINSTANCE.getTraceNbEdge(),
			ASPT.ASPTPackage.eINSTANCE.getTraceNbProp(),
			ASPT.ASPTPackage.eINSTANCE.getTraceNbNode(),
			ASPT.ASPTPackage.eINSTANCE.getTraceLink(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			ASPT.ASPTPackage.eINSTANCE.getTraceModel(),
		};
	}
	
}
