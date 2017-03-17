/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmPrinter implements ASPM.resource.aspm.IAspmTextPrinter {
	
	protected ASPM.resource.aspm.IAspmTokenResolverFactory tokenResolverFactory = new ASPM.resource.aspm.mopp.AspmTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private ASPM.resource.aspm.IAspmTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public AspmPrinter(java.io.OutputStream outputStream, ASPM.resource.aspm.IAspmTextResource resource) {
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
		
		if (element instanceof ASPM.Model) {
			print_ASPM_Model((ASPM.Model) element, globaltab, out);
			return;
		}
		if (element instanceof ASPM.Node) {
			print_ASPM_Node((ASPM.Node) element, globaltab, out);
			return;
		}
		if (element instanceof ASPM.Prop) {
			print_ASPM_Prop((ASPM.Prop) element, globaltab, out);
			return;
		}
		if (element instanceof ASPM.Edge) {
			print_ASPM_Edge((ASPM.Edge) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected ASPM.resource.aspm.mopp.AspmReferenceResolverSwitch getReferenceResolverSwitch() {
		return (ASPM.resource.aspm.mopp.AspmReferenceResolverSwitch) new ASPM.resource.aspm.mopp.AspmMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		ASPM.resource.aspm.IAspmTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new ASPM.resource.aspm.mopp.AspmProblem(errorMessage, ASPM.resource.aspm.AspmEProblemType.PRINT_PROBLEM, ASPM.resource.aspm.AspmEProblemSeverity.WARNING), cause);
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
	
	public ASPM.resource.aspm.IAspmTextResource getResource() {
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
	
	public void print_ASPM_Model(ASPM.Model element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID));
		printCountingMap.put("ID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NODES));
		printCountingMap.put("nodes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__EDGES));
		printCountingMap.put("edges", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__PROPS));
		printCountingMap.put("props", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("model");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("ID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__ID), element));
				out.print(" ");
			}
			printCountingMap.put("ID", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("nodes");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__NODES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("nodes", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("props");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__PROPS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("props", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("edges");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.MODEL__EDGES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("edges", 0);
		}
	}
	
	
	public void print_ASPM_Node(ASPM.Node element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID));
		printCountingMap.put("ID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE));
		printCountingMap.put("IDtrace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("node");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("model");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getNodeModelReferenceResolver().deResolve((ASPM.Model) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("model", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("ID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("ID", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("IDtrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__IDTRACE), element));
				out.print(" ");
			}
			printCountingMap.put("IDtrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.NODE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASPM_Prop(ASPM.Prop element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(10);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID));
		printCountingMap.put("ID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE));
		printCountingMap.put("IDtrace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE));
		printCountingMap.put("ownerTrace", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("prop");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("model");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropModelReferenceResolver().deResolve((ASPM.Model) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("model", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("ID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__ID), element));
				out.print(" ");
			}
			printCountingMap.put("ID", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("IDtrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__IDTRACE), element));
				out.print(" ");
			}
			printCountingMap.put("IDtrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("owner");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropOwnerReferenceResolver().deResolve((ASPM.Node) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER), element));
				out.print(" ");
			}
			printCountingMap.put("owner", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("ownerTrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__OWNER_TRACE), element));
				out.print(" ");
			}
			printCountingMap.put("ownerTrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.PROP__VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("value", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_ASPM_Edge(ASPM.Edge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(11);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID));
		printCountingMap.put("ID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE));
		printCountingMap.put("IDtrace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE));
		printCountingMap.put("sourceTrace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE));
		printCountingMap.put("targetTrace", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("edge");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("model");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeModelReferenceResolver().deResolve((ASPM.Model) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("model", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("ID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("ID", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("IDtrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__IDTRACE), element));
				out.print(" ");
			}
			printCountingMap.put("IDtrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("source");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeSourceReferenceResolver().deResolve((ASPM.Node) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("sourceTrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__SOURCE_TRACE), element));
				out.print(" ");
			}
			printCountingMap.put("sourceTrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdgeTargetReferenceResolver().deResolve((ASPM.Node) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET)), element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("targetTrace");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE));
			if (o != null) {
				ASPM.resource.aspm.IAspmTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPM.ASPMPackage.EDGE__TARGET_TRACE), element));
				out.print(" ");
			}
			printCountingMap.put("targetTrace", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
}
