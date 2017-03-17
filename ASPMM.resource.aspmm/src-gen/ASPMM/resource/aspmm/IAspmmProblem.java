/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

public interface IAspmmProblem {
	public String getMessage();
	public ASPMM.resource.aspmm.AspmmEProblemSeverity getSeverity();
	public ASPMM.resource.aspmm.AspmmEProblemType getType();
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> getQuickFixes();
}
