/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

public interface IAsptProblem {
	public String getMessage();
	public ASPT.resource.aspt.AsptEProblemSeverity getSeverity();
	public ASPT.resource.aspt.AsptEProblemType getType();
	public java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> getQuickFixes();
}
