/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

public interface IAspmProblem {
	public String getMessage();
	public ASPM.resource.aspm.AspmEProblemSeverity getSeverity();
	public ASPM.resource.aspm.AspmEProblemType getType();
	public java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> getQuickFixes();
}
