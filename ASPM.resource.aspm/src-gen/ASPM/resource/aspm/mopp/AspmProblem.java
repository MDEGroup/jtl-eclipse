/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmProblem implements ASPM.resource.aspm.IAspmProblem {
	
	private String message;
	private ASPM.resource.aspm.AspmEProblemType type;
	private ASPM.resource.aspm.AspmEProblemSeverity severity;
	private java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> quickFixes;
	
	public AspmProblem(String message, ASPM.resource.aspm.AspmEProblemType type, ASPM.resource.aspm.AspmEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<ASPM.resource.aspm.IAspmQuickFix>emptySet());
	}
	
	public AspmProblem(String message, ASPM.resource.aspm.AspmEProblemType type, ASPM.resource.aspm.AspmEProblemSeverity severity, ASPM.resource.aspm.IAspmQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public AspmProblem(String message, ASPM.resource.aspm.AspmEProblemType type, ASPM.resource.aspm.AspmEProblemSeverity severity, java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<ASPM.resource.aspm.IAspmQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public ASPM.resource.aspm.AspmEProblemType getType() {
		return type;
	}
	
	public ASPM.resource.aspm.AspmEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
