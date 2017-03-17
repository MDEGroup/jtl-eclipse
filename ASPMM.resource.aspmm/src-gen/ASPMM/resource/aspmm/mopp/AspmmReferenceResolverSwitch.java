/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmReferenceResolverSwitch implements ASPMM.resource.aspmm.IAspmmReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected ASPMM.resource.aspmm.analysis.MetanodeMetamodelReferenceResolver metanodeMetamodelReferenceResolver = new ASPMM.resource.aspmm.analysis.MetanodeMetamodelReferenceResolver();
	protected ASPMM.resource.aspmm.analysis.MetapropMetamodelReferenceResolver metapropMetamodelReferenceResolver = new ASPMM.resource.aspmm.analysis.MetapropMetamodelReferenceResolver();
	protected ASPMM.resource.aspmm.analysis.MetapropMetanodeReferenceResolver metapropMetanodeReferenceResolver = new ASPMM.resource.aspmm.analysis.MetapropMetanodeReferenceResolver();
	protected ASPMM.resource.aspmm.analysis.MetaedgeMetamodelReferenceResolver metaedgeMetamodelReferenceResolver = new ASPMM.resource.aspmm.analysis.MetaedgeMetamodelReferenceResolver();
	protected ASPMM.resource.aspmm.analysis.MetaedgeSourceReferenceResolver metaedgeSourceReferenceResolver = new ASPMM.resource.aspmm.analysis.MetaedgeSourceReferenceResolver();
	protected ASPMM.resource.aspmm.analysis.MetaedgeTargetReferenceResolver metaedgeTargetReferenceResolver = new ASPMM.resource.aspmm.analysis.MetaedgeTargetReferenceResolver();
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metanode, ASPMM.Metamodel> getMetanodeMetamodelReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetanode_Metamodel(), metanodeMetamodelReferenceResolver);
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaprop, ASPMM.Metamodel> getMetapropMetamodelReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop_Metamodel(), metapropMetamodelReferenceResolver);
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaprop, ASPMM.Metanode> getMetapropMetanodeReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetaprop_Metanode(), metapropMetanodeReferenceResolver);
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaedge, ASPMM.Metamodel> getMetaedgeMetamodelReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Metamodel(), metaedgeMetamodelReferenceResolver);
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaedge, ASPMM.Metanode> getMetaedgeSourceReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Source(), metaedgeSourceReferenceResolver);
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<ASPMM.Metaedge, ASPMM.Metanode> getMetaedgeTargetReferenceResolver() {
		return getResolverChain(ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Target(), metaedgeTargetReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		metanodeMetamodelReferenceResolver.setOptions(options);
		metapropMetamodelReferenceResolver.setOptions(options);
		metapropMetanodeReferenceResolver.setOptions(options);
		metaedgeMetamodelReferenceResolver.setOptions(options);
		metaedgeSourceReferenceResolver.setOptions(options);
		metaedgeTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, ASPMM.resource.aspmm.IAspmmReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetanode().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metamodel> frr = new AspmmFuzzyResolveResult<ASPMM.Metamodel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("metamodel")) {
				metanodeMetamodelReferenceResolver.resolve(identifier, (ASPMM.Metanode) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetaprop().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metamodel> frr = new AspmmFuzzyResolveResult<ASPMM.Metamodel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("metamodel")) {
				metapropMetamodelReferenceResolver.resolve(identifier, (ASPMM.Metaprop) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetaprop().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metanode> frr = new AspmmFuzzyResolveResult<ASPMM.Metanode>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("metanode")) {
				metapropMetanodeReferenceResolver.resolve(identifier, (ASPMM.Metaprop) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metamodel> frr = new AspmmFuzzyResolveResult<ASPMM.Metamodel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("metamodel")) {
				metaedgeMetamodelReferenceResolver.resolve(identifier, (ASPMM.Metaedge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metanode> frr = new AspmmFuzzyResolveResult<ASPMM.Metanode>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				metaedgeSourceReferenceResolver.resolve(identifier, (ASPMM.Metaedge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPMM.ASPMMPackage.eINSTANCE.getMetaedge().isInstance(container)) {
			AspmmFuzzyResolveResult<ASPMM.Metanode> frr = new AspmmFuzzyResolveResult<ASPMM.Metanode>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				metaedgeTargetReferenceResolver.resolve(identifier, (ASPMM.Metaedge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetanode_Metamodel()) {
			return getResolverChain(reference, metanodeMetamodelReferenceResolver);
		}
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetaprop_Metamodel()) {
			return getResolverChain(reference, metapropMetamodelReferenceResolver);
		}
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetaprop_Metanode()) {
			return getResolverChain(reference, metapropMetanodeReferenceResolver);
		}
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Metamodel()) {
			return getResolverChain(reference, metaedgeMetamodelReferenceResolver);
		}
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Source()) {
			return getResolverChain(reference, metaedgeSourceReferenceResolver);
		}
		if (reference == ASPMM.ASPMMPackage.eINSTANCE.getMetaedge_Target()) {
			return getResolverChain(reference, metaedgeTargetReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> ASPMM.resource.aspmm.IAspmmReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, ASPMM.resource.aspmm.IAspmmReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(ASPMM.resource.aspmm.IAspmmOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new ASPMM.resource.aspmm.util.AspmmRuntimeUtil().logWarning("Found value with invalid type for option " + ASPMM.resource.aspmm.IAspmmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof ASPMM.resource.aspmm.IAspmmReferenceResolver) {
			ASPMM.resource.aspmm.IAspmmReferenceResolver replacingResolver = (ASPMM.resource.aspmm.IAspmmReferenceResolver) resolverValue;
			if (replacingResolver instanceof ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			ASPMM.resource.aspmm.IAspmmReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof ASPMM.resource.aspmm.IAspmmReferenceCache) {
					ASPMM.resource.aspmm.IAspmmReferenceResolver nextResolver = (ASPMM.resource.aspmm.IAspmmReferenceResolver) next;
					if (nextResolver instanceof ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new ASPMM.resource.aspmm.util.AspmmRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPMM.resource.aspmm.IAspmmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new ASPMM.resource.aspmm.util.AspmmRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPMM.resource.aspmm.IAspmmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPMM.resource.aspmm.IAspmmDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
