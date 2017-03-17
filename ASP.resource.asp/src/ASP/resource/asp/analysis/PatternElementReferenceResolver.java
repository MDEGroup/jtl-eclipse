/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.analysis;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class PatternElementReferenceResolver implements ASP.resource.asp.IAspReferenceResolver<ASP.Pattern, ASP.Function> {
	
	@SuppressWarnings("unused")
	private ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Pattern, ASP.Function> delegate = new ASP.resource.asp.analysis.AspDefaultResolverDelegate<ASP.Pattern, ASP.Function>();
	
	public void resolve(String identifier, ASP.Pattern container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final ASP.resource.asp.IAspReferenceResolveResult<ASP.Function> result) {
		
		// Split identifier by comma to get literals
		List<String> literalsId = Arrays.asList(identifier.split(", ?"));
		
		// Go on searching for a matching Function having the specified literals
		EObject root = org.eclipse.emf.ecore.util.EcoreUtil.getRootContainer(container);
		EClass type = reference.getEReferenceType();
		for (java.util.Iterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
			EObject element = iterator.next();

			// Match the type
			if (type.getInstanceClass().isInstance(element)) {
				EStructuralFeature l = element.eClass().getEStructuralFeature("literals");
				
				// Match the list of literals
				@SuppressWarnings("unchecked")
				EList<EObject> literals = (EList<EObject>) element.eGet(l);
				if (literalsId.size() == literals.size()) {
					boolean found = true;
					for (Iterator<EObject> it = literals.iterator(); it.hasNext() && found; ){
						EObject lit = it.next();
						EStructuralFeature name = lit.eClass().getEStructuralFeature("name");
						if (!literalsId.contains(lit.eGet(name))) {
							// Not matching... try matching the next one
							found = false;
						}
					}

					if (found) {
						result.addMapping(identifier, (ASP.Function) element);
					}
				}
			}
		}
		
		// Default resolver delegation
		// delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(ASP.Function element, ASP.Pattern container, org.eclipse.emf.ecore.EReference reference) {
		// Get the relation ID from the name of the Relation element
		EStructuralFeature id = container.eContainer().eClass().getEStructuralFeature("name");
		String elementPrint = String.format("\"%s\", ", container.eContainer().eGet(id));
		
		// Implode the list of literals in a comma separated string
		EStructuralFeature l = element.eClass().getEStructuralFeature("literals");
		@SuppressWarnings("unchecked")
		EList<EObject> literals = (EList<EObject>) element.eGet(l);
		for (Iterator<EObject> it = literals.iterator(); it.hasNext();) {
			EObject lit = it.next();
			EStructuralFeature name = lit.eClass().getEStructuralFeature("name");
			elementPrint += lit.eGet(name);
			if (it.hasNext()) {
				elementPrint += ", ";
			}
		}
		elementPrint += ", 0";
		return elementPrint;
		// return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
