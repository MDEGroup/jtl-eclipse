/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

/**
 * A basic implementation of the ASPMM.resource.aspmm.IAspmmReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class AspmmReferenceResolveResult<ReferenceType> implements ASPMM.resource.aspmm.IAspmmReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<ASPMM.resource.aspmm.IAspmmReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<ASPMM.resource.aspmm.IAspmmQuickFix> quickFixes;
	
	public AspmmReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPMM.resource.aspmm.IAspmmQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(ASPMM.resource.aspmm.IAspmmQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPMM.resource.aspmm.IAspmmQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<ASPMM.resource.aspmm.IAspmmReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPMM.resource.aspmm.mopp.AspmmElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<ASPMM.resource.aspmm.IAspmmReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPMM.resource.aspmm.mopp.AspmmURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
