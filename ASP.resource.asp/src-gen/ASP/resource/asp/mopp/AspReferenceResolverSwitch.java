/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspReferenceResolverSwitch implements ASP.resource.asp.IAspReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected ASP.resource.asp.analysis.PatternElementReferenceResolver patternElementReferenceResolver = new ASP.resource.asp.analysis.PatternElementReferenceResolver();
	protected ASP.resource.asp.analysis.FunctionLiteralsReferenceResolver functionLiteralsReferenceResolver = new ASP.resource.asp.analysis.FunctionLiteralsReferenceResolver();
	protected ASP.resource.asp.analysis.RuleDirectionReferenceResolver ruleDirectionReferenceResolver = new ASP.resource.asp.analysis.RuleDirectionReferenceResolver();
	protected ASP.resource.asp.analysis.ConstraintDirectionReferenceResolver constraintDirectionReferenceResolver = new ASP.resource.asp.analysis.ConstraintDirectionReferenceResolver();
	protected ASP.resource.asp.analysis.TerminalElementReferenceResolver terminalElementReferenceResolver = new ASP.resource.asp.analysis.TerminalElementReferenceResolver();
	protected ASP.resource.asp.analysis.NotElementReferenceResolver notElementReferenceResolver = new ASP.resource.asp.analysis.NotElementReferenceResolver();
	protected ASP.resource.asp.analysis.EqLeftReferenceResolver eqLeftReferenceResolver = new ASP.resource.asp.analysis.EqLeftReferenceResolver();
	protected ASP.resource.asp.analysis.EqRightReferenceResolver eqRightReferenceResolver = new ASP.resource.asp.analysis.EqRightReferenceResolver();
	protected ASP.resource.asp.analysis.NotEqLeftReferenceResolver notEqLeftReferenceResolver = new ASP.resource.asp.analysis.NotEqLeftReferenceResolver();
	protected ASP.resource.asp.analysis.NotEqRightReferenceResolver notEqRightReferenceResolver = new ASP.resource.asp.analysis.NotEqRightReferenceResolver();
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Pattern, ASP.Function> getPatternElementReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getPattern_Element(), patternElementReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Function, ASP.Literal> getFunctionLiteralsReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getFunction_Literals(), functionLiteralsReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Rule, ASP.Literal> getRuleDirectionReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getRule_Direction(), ruleDirectionReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Constraint, ASP.Literal> getConstraintDirectionReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getConstraint_Direction(), constraintDirectionReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Terminal, ASP.Element> getTerminalElementReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getTerminal_Element(), terminalElementReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Not, ASP.Element> getNotElementReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getNot_Element(), notElementReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Eq, ASP.Literal> getEqLeftReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getEq_Left(), eqLeftReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.Eq, ASP.Literal> getEqRightReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getEq_Right(), eqRightReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.NotEq, ASP.Literal> getNotEqLeftReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getNotEq_Left(), notEqLeftReferenceResolver);
	}
	
	public ASP.resource.asp.IAspReferenceResolver<ASP.NotEq, ASP.Literal> getNotEqRightReferenceResolver() {
		return getResolverChain(ASP.ASPPackage.eINSTANCE.getNotEq_Right(), notEqRightReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		patternElementReferenceResolver.setOptions(options);
		functionLiteralsReferenceResolver.setOptions(options);
		ruleDirectionReferenceResolver.setOptions(options);
		constraintDirectionReferenceResolver.setOptions(options);
		terminalElementReferenceResolver.setOptions(options);
		notElementReferenceResolver.setOptions(options);
		eqLeftReferenceResolver.setOptions(options);
		eqRightReferenceResolver.setOptions(options);
		notEqLeftReferenceResolver.setOptions(options);
		notEqRightReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, ASP.resource.asp.IAspReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (ASP.ASPPackage.eINSTANCE.getPattern().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Function> frr = new AspFuzzyResolveResult<ASP.Function>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("element")) {
				patternElementReferenceResolver.resolve(identifier, (ASP.Pattern) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getFunction().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("literals")) {
				functionLiteralsReferenceResolver.resolve(identifier, (ASP.Function) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getRule().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("direction")) {
				ruleDirectionReferenceResolver.resolve(identifier, (ASP.Rule) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getConstraint().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("direction")) {
				constraintDirectionReferenceResolver.resolve(identifier, (ASP.Constraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getTerminal().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Element> frr = new AspFuzzyResolveResult<ASP.Element>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("element")) {
				terminalElementReferenceResolver.resolve(identifier, (ASP.Terminal) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getNot().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Element> frr = new AspFuzzyResolveResult<ASP.Element>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("element")) {
				notElementReferenceResolver.resolve(identifier, (ASP.Not) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getEq().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("left")) {
				eqLeftReferenceResolver.resolve(identifier, (ASP.Eq) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getEq().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("right")) {
				eqRightReferenceResolver.resolve(identifier, (ASP.Eq) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getNotEq().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("left")) {
				notEqLeftReferenceResolver.resolve(identifier, (ASP.NotEq) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (ASP.ASPPackage.eINSTANCE.getNotEq().isInstance(container)) {
			AspFuzzyResolveResult<ASP.Literal> frr = new AspFuzzyResolveResult<ASP.Literal>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("right")) {
				notEqRightReferenceResolver.resolve(identifier, (ASP.NotEq) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public ASP.resource.asp.IAspReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == ASP.ASPPackage.eINSTANCE.getPattern_Element()) {
			return getResolverChain(reference, patternElementReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getFunction_Literals()) {
			return getResolverChain(reference, functionLiteralsReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getRule_Direction()) {
			return getResolverChain(reference, ruleDirectionReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getConstraint_Direction()) {
			return getResolverChain(reference, constraintDirectionReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getTerminal_Element()) {
			return getResolverChain(reference, terminalElementReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getNot_Element()) {
			return getResolverChain(reference, notElementReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getEq_Left()) {
			return getResolverChain(reference, eqLeftReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getEq_Right()) {
			return getResolverChain(reference, eqRightReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getNotEq_Left()) {
			return getResolverChain(reference, notEqLeftReferenceResolver);
		}
		if (reference == ASP.ASPPackage.eINSTANCE.getNotEq_Right()) {
			return getResolverChain(reference, notEqRightReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> ASP.resource.asp.IAspReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, ASP.resource.asp.IAspReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(ASP.resource.asp.IAspOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new ASP.resource.asp.util.AspRuntimeUtil().logWarning("Found value with invalid type for option " + ASP.resource.asp.IAspOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof ASP.resource.asp.IAspReferenceResolver) {
			ASP.resource.asp.IAspReferenceResolver replacingResolver = (ASP.resource.asp.IAspReferenceResolver) resolverValue;
			if (replacingResolver instanceof ASP.resource.asp.IAspDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((ASP.resource.asp.IAspDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			ASP.resource.asp.IAspReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof ASP.resource.asp.IAspReferenceCache) {
					ASP.resource.asp.IAspReferenceResolver nextResolver = (ASP.resource.asp.IAspReferenceResolver) next;
					if (nextResolver instanceof ASP.resource.asp.IAspDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((ASP.resource.asp.IAspDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new ASP.resource.asp.util.AspRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASP.resource.asp.IAspOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASP.resource.asp.IAspDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new ASP.resource.asp.util.AspRuntimeUtil().logWarning("Found value with invalid type in value map for option " + ASP.resource.asp.IAspOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + ASP.resource.asp.IAspDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
