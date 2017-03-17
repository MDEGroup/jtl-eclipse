/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspProblem implements ASP.resource.asp.IAspProblem {
	
	private String message;
	private ASP.resource.asp.AspEProblemType type;
	private ASP.resource.asp.AspEProblemSeverity severity;
	private java.util.Collection<ASP.resource.asp.IAspQuickFix> quickFixes;
	
	public AspProblem(String message, ASP.resource.asp.AspEProblemType type, ASP.resource.asp.AspEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<ASP.resource.asp.IAspQuickFix>emptySet());
	}
	
	public AspProblem(String message, ASP.resource.asp.AspEProblemType type, ASP.resource.asp.AspEProblemSeverity severity, ASP.resource.asp.IAspQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public AspProblem(String message, ASP.resource.asp.AspEProblemType type, ASP.resource.asp.AspEProblemSeverity severity, java.util.Collection<ASP.resource.asp.IAspQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<ASP.resource.asp.IAspQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public ASP.resource.asp.AspEProblemType getType() {
		return type;
	}
	
	public ASP.resource.asp.AspEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<ASP.resource.asp.IAspQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
