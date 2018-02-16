/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptReferenceResolverSwitch implements ASPT.resource.aspt.IAsptReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, ASPT.resource.aspt.IAsptReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public ASPT.resource.aspt.IAsptReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> ASPT.resource.aspt.IAsptReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, ASPT.resource.aspt.IAsptReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(ASPT.resource.aspt.IAsptOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new ASPT.resource.aspt.util.AsptRuntimeUtil().logWarning("Found value with invalid type for option " + ASPT.resource.aspt.IAsptOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof ASPT.resource.aspt.IAsptReferenceResolver) {
			ASPT.resource.aspt.IAsptReferenceResolver replacingResolver = (ASPT.resource.aspt.IAsptReferenceResolver) resolverValue;
			if (replacingResolver instanceof ASPT.resource.aspt.IAsptDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((ASPT.resource.aspt.IAsptDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			ASPT.resource.aspt.IAsptReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof ASPT.resource.aspt.IAsptReferenceCache) {
					ASPT.resource.aspt.IAsptReferenceResolver nextResolver = (ASPT.resource.aspt.IAsptReferenceResolver) next;
					if (nextResolver instanceof ASPT.resource.aspt.IAsptDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((ASPT.resource.aspt.IAsptDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new ASPT.resource.aspt.util.AsptRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPT.resource.aspt.IAsptOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPT.resource.aspt.IAsptDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new ASPT.resource.aspt.util.AsptRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPT.resource.aspt.IAsptOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPT.resource.aspt.IAsptDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
