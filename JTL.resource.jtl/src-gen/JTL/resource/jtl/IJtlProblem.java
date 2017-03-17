/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

public interface IJtlProblem {
	public String getMessage();
	public JTL.resource.jtl.JtlEProblemSeverity getSeverity();
	public JTL.resource.jtl.JtlEProblemType getType();
	public java.util.Collection<JTL.resource.jtl.IJtlQuickFix> getQuickFixes();
}
