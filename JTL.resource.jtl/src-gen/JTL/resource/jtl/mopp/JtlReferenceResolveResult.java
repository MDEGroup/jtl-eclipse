/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

/**
 * A basic implementation of the JTL.resource.jtl.IJtlReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class JtlReferenceResolveResult<ReferenceType> implements JTL.resource.jtl.IJtlReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<JTL.resource.jtl.IJtlReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<JTL.resource.jtl.IJtlQuickFix> quickFixes;
	
	public JtlReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<JTL.resource.jtl.IJtlQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<JTL.resource.jtl.IJtlQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(JTL.resource.jtl.IJtlQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<JTL.resource.jtl.IJtlQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<JTL.resource.jtl.IJtlReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<JTL.resource.jtl.IJtlReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new JTL.resource.jtl.mopp.JtlElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<JTL.resource.jtl.IJtlReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new JTL.resource.jtl.mopp.JtlURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
