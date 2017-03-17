/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlReferenceResolverSwitch implements JTL.resource.jtl.IJtlReferenceResolverSwitch {
	
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
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, JTL.resource.jtl.IJtlReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public JTL.resource.jtl.IJtlReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> JTL.resource.jtl.IJtlReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, JTL.resource.jtl.IJtlReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(JTL.resource.jtl.IJtlOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new JTL.resource.jtl.util.JtlRuntimeUtil().logWarning("Found value with invalid type for option " + JTL.resource.jtl.IJtlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof JTL.resource.jtl.IJtlReferenceResolver) {
			JTL.resource.jtl.IJtlReferenceResolver replacingResolver = (JTL.resource.jtl.IJtlReferenceResolver) resolverValue;
			if (replacingResolver instanceof JTL.resource.jtl.IJtlDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((JTL.resource.jtl.IJtlDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			JTL.resource.jtl.IJtlReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof JTL.resource.jtl.IJtlReferenceCache) {
					JTL.resource.jtl.IJtlReferenceResolver nextResolver = (JTL.resource.jtl.IJtlReferenceResolver) next;
					if (nextResolver instanceof JTL.resource.jtl.IJtlDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((JTL.resource.jtl.IJtlDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new JTL.resource.jtl.util.JtlRuntimeUtil().logWarning("Found value with invalid type in value map for option " + JTL.resource.jtl.IJtlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + JTL.resource.jtl.IJtlDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new JTL.resource.jtl.util.JtlRuntimeUtil().logWarning("Found value with invalid type in value map for option " + JTL.resource.jtl.IJtlOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + JTL.resource.jtl.IJtlDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
