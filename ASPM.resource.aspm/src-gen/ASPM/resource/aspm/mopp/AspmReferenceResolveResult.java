/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

/**
 * A basic implementation of the ASPM.resource.aspm.IAspmReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class AspmReferenceResolveResult<ReferenceType> implements ASPM.resource.aspm.IAspmReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<ASPM.resource.aspm.IAspmReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<ASPM.resource.aspm.IAspmQuickFix> quickFixes;
	
	public AspmReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<ASPM.resource.aspm.IAspmQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPM.resource.aspm.IAspmQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(ASPM.resource.aspm.IAspmQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<ASPM.resource.aspm.IAspmQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<ASPM.resource.aspm.IAspmReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<ASPM.resource.aspm.IAspmReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPM.resource.aspm.mopp.AspmElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<ASPM.resource.aspm.IAspmReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new ASPM.resource.aspm.mopp.AspmURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
