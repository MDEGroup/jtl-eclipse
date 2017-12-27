/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.util;

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
public class AbstractAspInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<ASP.resource.asp.IAspInterpreterListener> listeners = new java.util.ArrayList<ASP.resource.asp.IAspInterpreterListener>();
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
		if (object instanceof ASP.Transformation) {
			result = interprete_ASP_Transformation((ASP.Transformation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.LeftPattern) {
			result = interprete_ASP_LeftPattern((ASP.LeftPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.RightPattern) {
			result = interprete_ASP_RightPattern((ASP.RightPattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Pattern) {
			result = interprete_ASP_Pattern((ASP.Pattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Rule) {
			result = interprete_ASP_Rule((ASP.Rule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Constraint) {
			result = interprete_ASP_Constraint((ASP.Constraint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Not) {
			result = interprete_ASP_Not((ASP.Not) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.And) {
			result = interprete_ASP_And((ASP.And) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Eq) {
			result = interprete_ASP_Eq((ASP.Eq) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.NotEq) {
			result = interprete_ASP_NotEq((ASP.NotEq) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Expression) {
			result = interprete_ASP_Expression((ASP.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.NamedFunction) {
			result = interprete_ASP_NamedFunction((ASP.NamedFunction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Prop) {
			result = interprete_ASP_Prop((ASP.Prop) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Edge) {
			result = interprete_ASP_Edge((ASP.Edge) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Function) {
			result = interprete_ASP_Function((ASP.Function) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Literal) {
			result = interprete_ASP_Literal((ASP.Literal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Node) {
			result = interprete_ASP_Node((ASP.Node) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Terminal) {
			result = interprete_ASP_Terminal((ASP.Terminal) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Metanode) {
			result = interprete_ASP_Metanode((ASP.Metanode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Metaprop) {
			result = interprete_ASP_Metaprop((ASP.Metaprop) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Metaedge) {
			result = interprete_ASP_Metaedge((ASP.Metaedge) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Element) {
			result = interprete_ASP_Element((ASP.Element) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof ASP.Relation) {
			result = interprete_ASP_Relation((ASP.Relation) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_ASP_Transformation(ASP.Transformation transformation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_LeftPattern(ASP.LeftPattern leftPattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_RightPattern(ASP.RightPattern rightPattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Pattern(ASP.Pattern pattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Rule(ASP.Rule rule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Constraint(ASP.Constraint constraint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Element(ASP.Element element, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Expression(ASP.Expression expression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Not(ASP.Not not, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_And(ASP.And and, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Eq(ASP.Eq eq, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_NotEq(ASP.NotEq notEq, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Function(ASP.Function function, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Literal(ASP.Literal literal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_NamedFunction(ASP.NamedFunction namedFunction, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Node(ASP.Node node, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Prop(ASP.Prop prop, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Edge(ASP.Edge edge, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Relation(ASP.Relation relation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Terminal(ASP.Terminal terminal, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Metanode(ASP.Metanode metanode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Metaprop(ASP.Metaprop metaprop, ContextType context) {
		return null;
	}
	
	public ResultType interprete_ASP_Metaedge(ASP.Metaedge metaedge, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (ASP.resource.asp.IAspInterpreterListener listener : listeners) {
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
	
	public void addListener(ASP.resource.asp.IAspInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(ASP.resource.asp.IAspInterpreterListener listener) {
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
