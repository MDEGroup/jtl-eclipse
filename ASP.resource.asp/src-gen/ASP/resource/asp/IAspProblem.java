/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp;

public interface IAspProblem {
	public String getMessage();
	public ASP.resource.asp.AspEProblemSeverity getSeverity();
	public ASP.resource.asp.AspEProblemType getType();
	public java.util.Collection<ASP.resource.asp.IAspQuickFix> getQuickFixes();
}
