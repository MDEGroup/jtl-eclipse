/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspPrinter implements ASP.resource.asp.IAspTextPrinter {
	
	protected ASP.resource.asp.IAspTokenResolverFactory tokenResolverFactory = new ASP.resource.asp.mopp.AspTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private ASP.resource.asp.IAspTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public AspPrinter(java.io.OutputStream outputStream, ASP.resource.asp.IAspTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof ASP.Transformation) {
			print_ASP_Transformation((ASP.Transformation) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Relation) {
			print_ASP_Relation((ASP.Relation) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.LeftPattern) {
			print_ASP_LeftPattern((ASP.LeftPattern) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.RightPattern) {
			print_ASP_RightPattern((ASP.RightPattern) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Metanode) {
			print_ASP_Metanode((ASP.Metanode) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Metaprop) {
			print_ASP_Metaprop((ASP.Metaprop) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Metaedge) {
			print_ASP_Metaedge((ASP.Metaedge) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Node) {
			print_ASP_Node((ASP.Node) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Prop) {
			print_ASP_Prop((ASP.Prop) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Edge) {
			print_ASP_Edge((ASP.Edge) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.NamedFunction) {
			print_ASP_NamedFunction((ASP.NamedFunction) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Rule) {
			print_ASP_Rule((ASP.Rule) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Constraint) {
			print_ASP_Constraint((ASP.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Literal) {
			print_ASP_Literal((ASP.Literal) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Terminal) {
			print_ASP_Terminal((ASP.Terminal) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Not) {
			print_ASP_Not((ASP.Not) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.Eq) {
			print_ASP_Eq((ASP.Eq) element, globaltab, out);
			return;
		}
		if (element instanceof ASP.NotEq) {
			print_ASP_NotEq((ASP.NotEq) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected ASP.resource.asp.mopp.AspReferenceResolverSwitch getReferenceResolverSwitch() {
		return (ASP.resource.asp.mopp.AspReferenceResolverSwitch) new ASP.resource.asp.mopp.AspMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		ASP.resource.asp.IAspTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new ASP.resource.asp.mopp.AspProblem(errorMessage, ASP.resource.asp.AspEProblemType.PRINT_PROBLEM, ASP.resource.asp.AspEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public ASP.resource.asp.IAspTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_ASP_Transformation(ASP.Transformation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__ELEMENTS));
		printCountingMap.put("elements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RELATIONS));
		printCountingMap.put("relations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__CONSTRAINTS));
		printCountingMap.put("constraints", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RULES));
		printCountingMap.put("rules", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("elements");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__ELEMENTS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("elements", 0);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("relations");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RELATIONS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("relations", 0);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rules");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__RULES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rules", 0);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("constraints");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TRANSFORMATION__CONSTRAINTS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("constraints", 0);
		}
	}
	
	
	public void print_ASP_Relation(ASP.Relation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__PATTERNS));
		printCountingMap.put("patterns", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("patterns");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__PATTERNS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("patterns", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("patterns");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RELATION__PATTERNS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("patterns", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_LeftPattern(ASP.LeftPattern element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT));
		printCountingMap.put("element", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("element");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_40_41");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternElementReferenceResolver().deResolve((ASP.Function) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.LEFT_PATTERN__ELEMENT), element));
			}
			printCountingMap.put("element", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
	}
	
	
	public void print_ASP_RightPattern(ASP.RightPattern element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT));
		printCountingMap.put("element", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("element");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_40_41");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPatternElementReferenceResolver().deResolve((ASP.Function) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.RIGHT_PATTERN__ELEMENT), element));
			}
			printCountingMap.put("element", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
	}
	
	
	public void print_ASP_Metanode(ASP.Metanode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metanode(");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METANODE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_Metaprop(ASP.Metaprop element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metaprop(");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAPROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_Metaedge(ASP.Metaedge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metaedge(");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.METAEDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_Node(ASP.Node element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__IS_NODEX));
		printCountingMap.put("isNodex", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isNodex");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__IS_NODEX));
			if (o != null) {
			}
			printCountingMap.put("isNodex", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NODE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_Prop(ASP.Prop element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__IS_PROPX));
		printCountingMap.put("isPropx", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isPropx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__IS_PROPX));
			if (o != null) {
			}
			printCountingMap.put("isPropx", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.PROP__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_Edge(ASP.Edge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__IS_EDGEX));
		printCountingMap.put("isEdgex", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isEdgex");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__IS_EDGEX));
			if (o != null) {
			}
			printCountingMap.put("isEdgex", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EDGE__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(").");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASP_NamedFunction(ASP.NamedFunction element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_ASP_NamedFunction_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_NamedFunction_0(ASP.NamedFunction element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFunctionLiteralsReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NAMED_FUNCTION__LITERALS), element));
			}
			printCountingMap.put("literals", count - 1);
		}
	}
	
	
	public void print_ASP_Rule(ASP.Rule element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT));
		printCountingMap.put("comment", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__HEAD));
		printCountingMap.put("head", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_ASP_Rule_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("head");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__HEAD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("head", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":-");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_ASP_Rule_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_Rule_0(ASP.Rule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("comment");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__COMMENT), element));
			}
			printCountingMap.put("comment", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_Rule_1(ASP.Rule element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.RULE__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
	public void print_ASP_Constraint(ASP.Constraint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__EXPRESSIONS));
		printCountingMap.put("expressions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT));
		printCountingMap.put("comment", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_ASP_Constraint_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":-");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_ASP_Constraint_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_Constraint_0(ASP.Constraint element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("comment");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__COMMENT), element));
			}
			printCountingMap.put("comment", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_Constraint_1(ASP.Constraint element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expressions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.CONSTRAINT__EXPRESSIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expressions", count - 1);
		}
	}
	
	
	public void print_ASP_Literal(ASP.Literal element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASP.ASPPackage.LITERAL__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_ASP_Literal_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_ASP_Literal_0(ASP.Literal element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		// DEFINITION PART BEGINS (WhiteSpaces)
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
	}
	
	
	public void print_ASP_Terminal(ASP.Terminal element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT));
		printCountingMap.put("element", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("element");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTerminalElementReferenceResolver().deResolve((ASP.Element) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.TERMINAL__ELEMENT), element));
			}
			printCountingMap.put("element", count - 1);
		}
	}
	
	
	public void print_ASP_Not(ASP.Not element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT));
		printCountingMap.put("element", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("not");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("element");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotElementReferenceResolver().deResolve((ASP.Element) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT__ELEMENT), element));
			}
			printCountingMap.put("element", count - 1);
		}
	}
	
	
	public void print_ASP_Eq(ASP.Eq element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEqLeftReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__LEFT), element));
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("==");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEqRightReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.EQ__RIGHT), element));
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	
	public void print_ASP_NotEq(ASP.NotEq element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT));
		printCountingMap.put("right", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("left");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotEqLeftReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__LEFT), element));
			}
			printCountingMap.put("left", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("!=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("right");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT));
			if (o != null) {
				ASP.resource.asp.IAspTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNotEqRightReferenceResolver().deResolve((ASP.Literal) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT)), element.eClass().getEStructuralFeature(ASP.ASPPackage.NOT_EQ__RIGHT), element));
			}
			printCountingMap.put("right", count - 1);
		}
	}
	
	
}
