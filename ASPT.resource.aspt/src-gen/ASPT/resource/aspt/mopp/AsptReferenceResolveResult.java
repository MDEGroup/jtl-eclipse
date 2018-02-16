/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

/**
 * A basic implementation of the ASPT.resource.aspt.IAsptReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class AsptReferenceResolveResult<ReferenceType> implements ASPT.resource.aspt.IAsptReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<ASPT.resource.aspt.IAsptReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<ASPT.resource.aspt.IAsptQuickFix> quickFixes;
	
	public AsptReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPT.resource.aspt.IAsptQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(ASPT.resource.aspt.IAsptQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPT.resource.aspt.IAsptQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<ASPT.resource.aspt.IAsptReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPT.resource.aspt.mopp.AsptElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<ASPT.resource.aspt.IAsptReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPT.resource.aspt.mopp.AsptURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
