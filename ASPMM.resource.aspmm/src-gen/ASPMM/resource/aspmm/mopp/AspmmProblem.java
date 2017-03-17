/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmProblem implements ASPMM.resource.aspmm.IAspmmProblem {
	
	private String message;
	private ASPMM.resource.aspmm.AspmmEProblemType type;
	private ASPMM.resource.aspmm.AspmmEProblemSeverity severity;
	private java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> quickFixes;
	
	public AspmmProblem(String message, ASPMM.resource.aspmm.AspmmEProblemType type, ASPMM.resource.aspmm.AspmmEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<ASPMM.resource.aspmm.IAspmmQuickFix>emptySet());
	}
	
	public AspmmProblem(String message, ASPMM.resource.aspmm.AspmmEProblemType type, ASPMM.resource.aspmm.AspmmEProblemSeverity severity, ASPMM.resource.aspmm.IAspmmQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public AspmmProblem(String message, ASPMM.resource.aspmm.AspmmEProblemType type, ASPMM.resource.aspmm.AspmmEProblemSeverity severity, java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<ASPMM.resource.aspmm.IAspmmQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public ASPMM.resource.aspmm.AspmmEProblemType getType() {
		return type;
	}
	
	public ASPMM.resource.aspmm.AspmmEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
