/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmReferenceResolverSwitch implements ASPM.resource.aspm.IAspmReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected ASPM.resource.aspm.analysis.NodeModelReferenceResolver nodeModelReferenceResolver = new ASPM.resource.aspm.analysis.NodeModelReferenceResolver();
	protected ASPM.resource.aspm.analysis.PropModelReferenceResolver propModelReferenceResolver = new ASPM.resource.aspm.analysis.PropModelReferenceResolver();
	protected ASPM.resource.aspm.analysis.PropOwnerReferenceResolver propOwnerReferenceResolver = new ASPM.resource.aspm.analysis.PropOwnerReferenceResolver();
	protected ASPM.resource.aspm.analysis.EdgeModelReferenceResolver edgeModelReferenceResolver = new ASPM.resource.aspm.analysis.EdgeModelReferenceResolver();
	protected ASPM.resource.aspm.analysis.EdgeSourceReferenceResolver edgeSourceReferenceResolver = new ASPM.resource.aspm.analysis.EdgeSourceReferenceResolver();
	protected ASPM.resource.aspm.analysis.EdgeTargetReferenceResolver edgeTargetReferenceResolver = new ASPM.resource.aspm.analysis.EdgeTargetReferenceResolver();
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Node, ASPM.Model> getNodeModelReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getNode_Model(), nodeModelReferenceResolver);
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Prop, ASPM.Model> getPropModelReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getProp_Model(), propModelReferenceResolver);
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Prop, ASPM.Node> getPropOwnerReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getProp_Owner(), propOwnerReferenceResolver);
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Edge, ASPM.Model> getEdgeModelReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getEdge_Model(), edgeModelReferenceResolver);
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Edge, ASPM.Node> getEdgeSourceReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getEdge_Source(), edgeSourceReferenceResolver);
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<ASPM.Edge, ASPM.Node> getEdgeTargetReferenceResolver() {
		return getResolverChain(ASPM.ASPMPackage.eINSTANCE.getEdge_Target(), edgeTargetReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		nodeModelReferenceResolver.setOptions(options);
		propModelReferenceResolver.setOptions(options);
		propOwnerReferenceResolver.setOptions(options);
		edgeModelReferenceResolver.setOptions(options);
		edgeSourceReferenceResolver.setOptions(options);
		edgeTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, ASPM.resource.aspm.IAspmReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (ASPM.ASPMPackage.eINSTANCE.getNode().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Model> frr = new AspmFuzzyResolveResult<ASPM.Model>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("model")) {
				nodeModelReferenceResolver.resolve(identifier, (ASPM.Node) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPM.ASPMPackage.eINSTANCE.getProp().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Model> frr = new AspmFuzzyResolveResult<ASPM.Model>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("model")) {
				propModelReferenceResolver.resolve(identifier, (ASPM.Prop) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPM.ASPMPackage.eINSTANCE.getProp().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Node> frr = new AspmFuzzyResolveResult<ASPM.Node>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("owner")) {
				propOwnerReferenceResolver.resolve(identifier, (ASPM.Prop) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPM.ASPMPackage.eINSTANCE.getEdge().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Model> frr = new AspmFuzzyResolveResult<ASPM.Model>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("model")) {
				edgeModelReferenceResolver.resolve(identifier, (ASPM.Edge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPM.ASPMPackage.eINSTANCE.getEdge().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Node> frr = new AspmFuzzyResolveResult<ASPM.Node>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				edgeSourceReferenceResolver.resolve(identifier, (ASPM.Edge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASPM.ASPMPackage.eINSTANCE.getEdge().isInstance(container)) {
			AspmFuzzyResolveResult<ASPM.Node> frr = new AspmFuzzyResolveResult<ASPM.Node>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				edgeTargetReferenceResolver.resolve(identifier, (ASPM.Edge) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == ASPM.ASPMPackage.eINSTANCE.getNode_Model()) {
			return getResolverChain(reference, nodeModelReferenceResolver);
		}
		if (reference == ASPM.ASPMPackage.eINSTANCE.getProp_Model()) {
			return getResolverChain(reference, propModelReferenceResolver);
		}
		if (reference == ASPM.ASPMPackage.eINSTANCE.getProp_Owner()) {
			return getResolverChain(reference, propOwnerReferenceResolver);
		}
		if (reference == ASPM.ASPMPackage.eINSTANCE.getEdge_Model()) {
			return getResolverChain(reference, edgeModelReferenceResolver);
		}
		if (reference == ASPM.ASPMPackage.eINSTANCE.getEdge_Source()) {
			return getResolverChain(reference, edgeSourceReferenceResolver);
		}
		if (reference == ASPM.ASPMPackage.eINSTANCE.getEdge_Target()) {
			return getResolverChain(reference, edgeTargetReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> ASPM.resource.aspm.IAspmReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, ASPM.resource.aspm.IAspmReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(ASPM.resource.aspm.IAspmOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new ASPM.resource.aspm.util.AspmRuntimeUtil().logWarning("Found value with invalid type for option " + ASPM.resource.aspm.IAspmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof ASPM.resource.aspm.IAspmReferenceResolver) {
			ASPM.resource.aspm.IAspmReferenceResolver replacingResolver = (ASPM.resource.aspm.IAspmReferenceResolver) resolverValue;
			if (replacingResolver instanceof ASPM.resource.aspm.IAspmDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((ASPM.resource.aspm.IAspmDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			ASPM.resource.aspm.IAspmReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof ASPM.resource.aspm.IAspmReferenceCache) {
					ASPM.resource.aspm.IAspmReferenceResolver nextResolver = (ASPM.resource.aspm.IAspmReferenceResolver) next;
					if (nextResolver instanceof ASPM.resource.aspm.IAspmDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((ASPM.resource.aspm.IAspmDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new ASPM.resource.aspm.util.AspmRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPM.resource.aspm.IAspmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPM.resource.aspm.IAspmDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new ASPM.resource.aspm.util.AspmRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASPM.resource.aspm.IAspmOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASPM.resource.aspm.IAspmDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
