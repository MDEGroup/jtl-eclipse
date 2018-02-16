/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractAsptInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<ASPT.resource.aspt.IAsptInterpreterListener> listeners = new java.util.ArrayList<ASPT.resource.aspt.IAsptInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof ASPT.TraceModel) {
			result = interprete_ASPT_TraceModel((ASPT.TraceModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceLink) {
			result = interprete_ASPT_TraceLink((ASPT.TraceLink) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceNode) {
			result = interprete_ASPT_TraceNode((ASPT.TraceNode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceNbProp) {
			result = interprete_ASPT_TraceNbProp((ASPT.TraceNbProp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceProp) {
			result = interprete_ASPT_TraceProp((ASPT.TraceProp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceEdge) {
			result = interprete_ASPT_TraceEdge((ASPT.TraceEdge) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceNbNode) {
			result = interprete_ASPT_TraceNbNode((ASPT.TraceNbNode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceNbEdge) {
			result = interprete_ASPT_TraceNbEdge((ASPT.TraceNbEdge) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASPT.TraceElement) {
			result = interprete_ASPT_TraceElement((ASPT.TraceElement) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_ASPT_TraceModel(ASPT.TraceModel traceModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceLink(ASPT.TraceLink traceLink, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceElement(ASPT.TraceElement traceElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceNode(ASPT.TraceNode traceNode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceProp(ASPT.TraceProp traceProp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceEdge(ASPT.TraceEdge traceEdge, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceNbNode(ASPT.TraceNbNode traceNbNode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceNbProp(ASPT.TraceNbProp traceNbProp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASPT_TraceNbEdge(ASPT.TraceNbEdge traceNbEdge, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (ASPT.resource.aspt.IAsptInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(ASPT.resource.aspt.IAsptInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(ASPT.resource.aspt.IAsptInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
