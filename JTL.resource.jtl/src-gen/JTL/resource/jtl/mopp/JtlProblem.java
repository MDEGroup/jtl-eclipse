/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlProblem implements JTL.resource.jtl.IJtlProblem {
	
	private String message;
	private JTL.resource.jtl.JtlEProblemType type;
	private JTL.resource.jtl.JtlEProblemSeverity severity;
	private java.util.Collection<JTL.resource.jtl.IJtlQuickFix> quickFixes;
	
	public JtlProblem(String message, JTL.resource.jtl.JtlEProblemType type, JTL.resource.jtl.JtlEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<JTL.resource.jtl.IJtlQuickFix>emptySet());
	}
	
	public JtlProblem(String message, JTL.resource.jtl.JtlEProblemType type, JTL.resource.jtl.JtlEProblemSeverity severity, JTL.resource.jtl.IJtlQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public JtlProblem(String message, JTL.resource.jtl.JtlEProblemType type, JTL.resource.jtl.JtlEProblemSeverity severity, java.util.Collection<JTL.resource.jtl.IJtlQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<JTL.resource.jtl.IJtlQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public JTL.resource.jtl.JtlEProblemType getType() {
		return type;
	}
	
	public JTL.resource.jtl.JtlEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<JTL.resource.jtl.IJtlQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
