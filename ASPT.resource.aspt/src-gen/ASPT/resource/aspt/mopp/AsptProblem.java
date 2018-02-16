/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptProblem implements ASPT.resource.aspt.IAsptProblem {
	
	private String message;
	private ASPT.resource.aspt.AsptEProblemType type;
	private ASPT.resource.aspt.AsptEProblemSeverity severity;
	private java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> quickFixes;
	
	public AsptProblem(String message, ASPT.resource.aspt.AsptEProblemType type, ASPT.resource.aspt.AsptEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<ASPT.resource.aspt.IAsptQuickFix>emptySet());
	}
	
	public AsptProblem(String message, ASPT.resource.aspt.AsptEProblemType type, ASPT.resource.aspt.AsptEProblemSeverity severity, ASPT.resource.aspt.IAsptQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public AsptProblem(String message, ASPT.resource.aspt.AsptEProblemType type, ASPT.resource.aspt.AsptEProblemSeverity severity, java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<ASPT.resource.aspt.IAsptQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public ASPT.resource.aspt.AsptEProblemType getType() {
		return type;
	}
	
	public ASPT.resource.aspt.AsptEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
