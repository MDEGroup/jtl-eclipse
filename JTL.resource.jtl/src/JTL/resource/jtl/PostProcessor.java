package JTL.resource.jtl;

import java.util.Collections;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import JTL.JTL.impl.DomainImpl;
import JTL.JTL.impl.ModelImpl;
import JTL.JTL.impl.PatternImpl;
import JTL.JTL.impl.RelationImpl;
import JTL.emof.impl.ElementImpl;
import JTL.essentialocl.impl.BooleanLiteralExpImpl;
import JTL.essentialocl.impl.OperationCallExpImpl;
import JTL.essentialocl.impl.VariableExpImpl;
import JTL.essentialocl.impl.VariableImpl;
import JTL.imperativeocl.impl.AssignExpImpl;
import JTL.resource.jtl.mopp.JtlResource;
import JTL.template.impl.ObjectTemplateExpImpl;

public class PostProcessor implements IJtlOptionProvider, IJtlResourcePostProcessor, IJtlResourcePostProcessorProvider {

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IJtlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}
	
	@Override
	public IJtlResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public void process(JtlResource resource) {
		EObject root = resource.getContents().get(0);
		// perform model modifications here
		
		// Set the value of Transformation->Relation->Domain.model
		ListIterator<EObject> domains = find(root, DomainImpl.class).listIterator();
		while (domains.hasNext()) {
			EObject domain = domains.next();
			EStructuralFeature f = domain.eClass().getEStructuralFeature("name");
			if (domain.eIsSet(f)) {
				EObject modelimpl = findSingle(root, ModelImpl.class, "name", domain.eGet(f));
				if (modelimpl != null) {
					EStructuralFeature model = domain.eClass().getEStructuralFeature("model");
					domain.eSet(model, modelimpl);
				}
			}
		}
		
		// Set the value of Transformation->Relation->Domain->Pattern.domain
		ListIterator<EObject> patterns = find(root, PatternImpl.class).listIterator();
		while (patterns.hasNext()) {
			EObject pattern = patterns.next();
			EStructuralFeature domain = pattern.eClass().getEStructuralFeature("domain");
			// If the Pattern has a Domain container use it
			if (DomainImpl.class.isInstance(pattern.eContainer())) {
				pattern.eSet(domain, pattern.eContainer());
			// Otherwise use the first Domain in the current Relation
			// FIXME Does this make any sense?
			} else {
				EObject relation = findInPath(root, pattern, RelationImpl.class);
				ListIterator<EObject> l = relation.eContents().listIterator();
				while (l.hasNext()) {
					EObject child = l.next();
					if (DomainImpl.class.isInstance(child)) {
						pattern.eSet(domain, child);
					}
				}
			}
		}

		// Set the value of BooleanLiteralExp.name
		ListIterator<EObject> boolexps = find(root, BooleanLiteralExpImpl.class).listIterator();
		while (boolexps.hasNext()) {
			EObject boolexp = boolexps.next();
			EStructuralFeature name = boolexp.eClass().getEStructuralFeature("name");
			EStructuralFeature value = boolexp.eClass().getEStructuralFeature("booleanSymbol");
			EStructuralFeature pname = boolexp.eContainer().eClass().getEStructuralFeature("name");
			boolexp.eSet(name, boolexp.eContainer().eGet(pname).toString() + "=" + boolexp.eGet(value));
		}

		// Replace VariableExp with ObjectTemplateExp in the context of an OperationCallExp
		ExtendedMetaData modelMetaData = new BasicExtendedMetaData(resource.getResourceSet().getPackageRegistry());
		ListIterator<EObject> opcallexps = find(root, OperationCallExpImpl.class).listIterator();
		while (opcallexps.hasNext()) {
			EObject opcallexp = opcallexps.next();

			// Set the missing OperationCallExp.referredOperation attribute
			// to the Relation with the corresponding name
			EStructuralFeature oceName = opcallexp.eClass().getEStructuralFeature("name");
			EStructuralFeature oceRefOp = opcallexp.eClass().getEStructuralFeature("referredOperation");
			EObject relation = findSingle(root, RelationImpl.class, "name", opcallexp.eGet(oceName));
			if (relation != null) {
				opcallexp.eSet(oceRefOp, relation);
			}
			
			EStructuralFeature argument = opcallexp.eClass().getEStructuralFeature("argument");
			if (opcallexp.eIsSet(argument)) {
				ListIterator<EObject> t = opcallexp.eContents().listIterator();
				while (t.hasNext()) {
					EObject varexp = t.next();
					EStructuralFeature veName = varexp.eClass().getEStructuralFeature("name");
					if (VariableExpImpl.class.isInstance(varexp)) {
						// Replace the VariableExp object with the ObjectTemplateExp
						// with the ObjectTemplateExp with the same name
						EObject objtplexp = findSingle(
								findInPath(root, varexp, RelationImpl.class), 
								ObjectTemplateExpImpl.class, "name", varexp.eGet(veName));
						if (objtplexp != null) {
							EcoreUtil.replace(varexp, EcoreUtil.copy(objtplexp));
						}
					}
				}
			}
		}
		
		// Set the value of OperationCallExp.referredOperation
		opcallexps = find(root, OperationCallExpImpl.class).listIterator();
		while (opcallexps.hasNext()) {
			EObject opcallexp = opcallexps.next();
			EStructuralFeature name = opcallexp.eClass().getEStructuralFeature("name");
			EStructuralFeature referredOperation = opcallexp.eClass().getEStructuralFeature("referredOperation");
			opcallexp.eSet(referredOperation, findSingle(root, RelationImpl.class, "name", opcallexp.eGet(name)));
		}
		
		// Set the value of VariableExp.referredVariable
		ListIterator<EObject> varexps = find(root, VariableExpImpl.class).listIterator();
		while (varexps.hasNext()) {
			EObject varexp = varexps.next();
			EStructuralFeature f = varexp.eClass().getEStructuralFeature("name");
			if (varexp.eIsSet(f)) {
				EObject relation = findInPath(root, varexp, RelationImpl.class);
				EObject varimpl = findSingle(relation, VariableImpl.class, "name", varexp.eGet(f));
				if (varimpl != null) {
					EStructuralFeature refvar = varexp.eClass().getEStructuralFeature("referredVariable");
					varexp.eSet(refvar, varimpl);
				}
			}
		}
		
		// Create the PropertyCallExp element as AssignExp.left
		EClass propertyCallExpEClass = (EClass) modelMetaData.getType("http:///essentialocl.ecore", "PropertyCallExp");
		ListIterator<EObject> assignexps = find(root, AssignExpImpl.class).listIterator();
		while (assignexps.hasNext()) {
			EObject assignexp = assignexps.next();
			EStructuralFeature f = assignexp.eClass().getEStructuralFeature("name");
			if (assignexp.eIsSet(f)) {
				EObject propertyCallExp = EcoreUtil.create(propertyCallExpEClass);
				propertyCallExp.eSet(f, assignexp.eGet(f));
				EStructuralFeature left = assignexp.eClass().getEStructuralFeature("left");
				assignexp.eSet(left, propertyCallExp);
			}
		}
		
		// In the case of endogenous transformations, rename the source and target metamodels
		endogenousTransformationRename(root);
		
	}

	@Override
	public void terminate() { }
	
	/**
	 * Find instances of a specific class in the model.
	 * @param root - Model root.
	 * @param implClass - Class to find.
	 * @return A list of found instances (if any).
	 */
	private EList<EObject> find(EObject root, Class<? extends ElementImpl> implClass) {
		EList<EObject> found = new BasicEList<EObject>();
		TreeIterator<EObject> t = root.eAllContents();
		while (t.hasNext()) {
			EObject next = t.next();
			if (implClass.isInstance(next)) {
				found.add(next);
			}
		}
		return found;
	}
	
	/**
	 * Find instances of a specific class in the model having a provided feature.
	 * @param root - Model root.
	 * @param implClass - Class to find.
	 * @param feature - Feature to look for.
	 * @param value - Value of the feature to look for.
	 * @return A list of found instances (if any).
	 */
	private EList<EObject> find(EObject root, Class<? extends ElementImpl> implClass, String feature, Object value) {
		EList<EObject> found = new BasicEList<EObject>();
		TreeIterator<EObject> t = root.eAllContents();
		while (t.hasNext()) {
			EObject next = t.next();
			if (implClass.isInstance(next)) {
				EStructuralFeature f = next.eClass().getEStructuralFeature(feature);
				if (next.eIsSet(f) && next.eGet(f).equals(value)) {
					found.add(next);
				}
			}
		}
		return found;
	}
	
	/**
	 * Find a single instance of a specific class having a provided feature.
	 * 
	 * @param root - Model root.
	 * @param implClass - Class to find.
	 * @param feature - Feature to look for.
	 * @param value - Value of the feature to look for.
	 * @return The found instance only if it is the single one in the model.
	 */
	private EObject findSingle(EObject root, Class<? extends ElementImpl> implClass, String feature, Object value) {
		EList<EObject> l = find(root, implClass, feature, value);
		switch (l.size()) {
			case 0:
				// FIXME track down who is causing this
				//System.out.format("No %s element named '%s' found.\n", implClass.toString(), value);
				break;
			case 1:
				return l.get(0);
			default:
				// FIXME track down who is causing this
				//System.out.format("More than one %s element named '%s'.\n", implClass.toString(), value);
				break;
		}
		return null;

	}
	
	/**
	 * Find the first istance of a specific class along the path to root.
	 * 
	 * @param root - Model root.
	 * @param currentObj - Model starting point.
	 * @param implClass - Class to find.
	 * @return EObject reference to the found class.
	 */
	private EObject findInPath(EObject root, EObject currentObj, Class<? extends ElementImpl> implClass) {
		if (implClass.isInstance(currentObj)) {
			return currentObj;
		} else if (currentObj != root) {
			return findInPath(root, currentObj.eContainer(), implClass);
		}
		return null;
	}
	
	/**
	 * Rename the type feature of all the ObjectTemplateExp
	 * objects found in a domain.
	 * @param domain - Domain element
	 */
	private void renameObjTplExpTypeInDomain(EObject domain, String rename) {
		ListIterator<EObject> objtplexps =
				find(domain, ObjectTemplateExpImpl.class).listIterator();
		while (objtplexps.hasNext()) {
			EObject objtplexp = objtplexps.next();
			EStructuralFeature type = objtplexp.eClass().getEStructuralFeature("type");
			objtplexp.eSet(type, rename);
		}
		
	}
	
	/*
	 * In the case of endogenous transformations,
	 * rename the source and target metamodels.
	 * 
	 * @param root - Model root.
	 */
	private void endogenousTransformationRename(EObject root) {
		ListIterator<EObject> l = root.eContents().listIterator();
		EObject model1 = l.next();
		EObject model2 = l.next();
		EStructuralFeature metamodelname = model1.eClass().getEStructuralFeature("usedPackage");
		if (!model1.eGet(metamodelname).equals(model2.eGet(metamodelname))) {
			return;
		}
		
		// Endogenous case
		String sourcemmRename = model1.eGet(metamodelname) + "_source";
		String targetmmRename = model2.eGet(metamodelname) + "_target";
		
		// Change metamodels names
		model1.eSet(metamodelname, sourcemmRename);
		model2.eSet(metamodelname, targetmmRename);
		
		// Iterate over relations to rename ObjectTemplateExp.type
		while (l.hasNext()) {
			EObject relation = l.next();
			if (RelationImpl.class.isInstance(relation)) {
				EList<EObject> domains = relation.eContents();
				
				// Look for ObjectTemplateExp in the first (source) domain
				EObject domain1 = domains.get(0);
				renameObjTplExpTypeInDomain(domain1, sourcemmRename);
				
				// Look for ObjectTemplateExp in the second (target) domain
				EObject domain2 = domains.get(1);
				renameObjTplExpTypeInDomain(domain2, targetmmRename);
			}
		}
	}
}
