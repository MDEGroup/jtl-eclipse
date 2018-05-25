/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptPrinter implements ASPT.resource.aspt.IAsptTextPrinter {
	
	protected ASPT.resource.aspt.IAsptTokenResolverFactory tokenResolverFactory = new ASPT.resource.aspt.mopp.AsptTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private ASPT.resource.aspt.IAsptTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public AsptPrinter(java.io.OutputStream outputStream, ASPT.resource.aspt.IAsptTextResource resource) {
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
		
		if (element instanceof ASPT.TraceModel) {
			print_ASPT_TraceModel((ASPT.TraceModel) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceNbEdge) {
			print_ASPT_TraceNbEdge((ASPT.TraceNbEdge) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceNbProp) {
			print_ASPT_TraceNbProp((ASPT.TraceNbProp) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceNbNode) {
			print_ASPT_TraceNbNode((ASPT.TraceNbNode) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceLink) {
			print_ASPT_TraceLink((ASPT.TraceLink) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceNode) {
			print_ASPT_TraceNode((ASPT.TraceNode) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceProp) {
			print_ASPT_TraceProp((ASPT.TraceProp) element, globaltab, out);
			return;
		}
		if (element instanceof ASPT.TraceEdge) {
			print_ASPT_TraceEdge((ASPT.TraceEdge) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected ASPT.resource.aspt.mopp.AsptReferenceResolverSwitch getReferenceResolverSwitch() {
		return (ASPT.resource.aspt.mopp.AsptReferenceResolverSwitch) new ASPT.resource.aspt.mopp.AsptMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		ASPT.resource.aspt.IAsptTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new ASPT.resource.aspt.mopp.AsptProblem(errorMessage, ASPT.resource.aspt.AsptEProblemType.PRINT_PROBLEM, ASPT.resource.aspt.AsptEProblemSeverity.WARNING), cause);
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
	
	public ASPT.resource.aspt.IAsptTextResource getResource() {
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
	
	public void print_ASPT_TraceModel(ASPT.TraceModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACELINKS));
		printCountingMap.put("tracelinks", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS));
		printCountingMap.put("traceelements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID));
		printCountingMap.put("ID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS));
		printCountingMap.put("MMS", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_model");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("ID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__ID), element));
				out.print(" ");
			}
			printCountingMap.put("ID", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("MMS");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__MMS), element));
				out.print(" ");
			}
			printCountingMap.put("MMS", count - 1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_ASPT_TraceModel_0(element, localtab, out1, printCountingMap1);
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
	}
	
	public void print_ASPT_TraceModel_0(ASPT.TraceModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"traceelements"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"tracelinks"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("tracelinks");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACELINKS));
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
					printCountingMap.put("tracelinks", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("traceelements");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_MODEL__TRACEELEMENTS));
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
				printCountingMap.put("traceelements", count - 1);
			}
		}
	}
	
	
	public void print_ASPT_TraceNode(ASPT.TraceNode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_node");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NODE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
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
	
	
	public void print_ASPT_TraceProp(ASPT.TraceProp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP));
		printCountingMap.put("idp", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX));
		printCountingMap.put("idpx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_prop");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("idp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDP), element));
				out.print(" ");
			}
			printCountingMap.put("idp", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idpx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__IDPX), element));
				out.print(" ");
			}
			printCountingMap.put("idpx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_PROP__VALUE), element));
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
	
	
	public void print_ASPT_TraceEdge(ASPT.TraceEdge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS));
		printCountingMap.put("ids", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX));
		printCountingMap.put("idsx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT));
		printCountingMap.put("idt", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX));
		printCountingMap.put("idtx", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_edge");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("ids");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDS), element));
				out.print(" ");
			}
			printCountingMap.put("ids", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idsx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDSX), element));
				out.print(" ");
			}
			printCountingMap.put("idsx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("idt");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDT), element));
				out.print(" ");
			}
			printCountingMap.put("idt", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idtx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_EDGE__IDTX), element));
				out.print(" ");
			}
			printCountingMap.put("idtx", count - 1);
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
	
	
	public void print_ASPT_TraceNbEdge(ASPT.TraceNbEdge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS));
		printCountingMap.put("ids", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX));
		printCountingMap.put("idsx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT));
		printCountingMap.put("idt", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX));
		printCountingMap.put("idtx", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_nb_edge");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("ids");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDS), element));
				out.print(" ");
			}
			printCountingMap.put("ids", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idsx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDSX), element));
				out.print(" ");
			}
			printCountingMap.put("idsx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("idt");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDT), element));
				out.print(" ");
			}
			printCountingMap.put("idt", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idtx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_EDGE__IDTX), element));
				out.print(" ");
			}
			printCountingMap.put("idtx", count - 1);
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
	
	
	public void print_ASPT_TraceNbProp(ASPT.TraceNbProp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP));
		printCountingMap.put("idp", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX));
		printCountingMap.put("idpx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_nb_prop");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("idp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDP), element));
				out.print(" ");
			}
			printCountingMap.put("idp", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idpx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__IDPX), element));
				out.print(" ");
			}
			printCountingMap.put("idpx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_PROP__VALUE), element));
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
	
	
	public void print_ASPT_TraceNbNode(ASPT.TraceNbNode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_nb_node");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_NB_NODE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
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
	
	
	public void print_ASPT_TraceLink(ASPT.TraceLink element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX));
		printCountingMap.put("idx", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION));
		printCountingMap.put("relation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREF));
		printCountingMap.put("idref", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREFX));
		printCountingMap.put("idrefx", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("trace_link");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDX), element));
				out.print(" ");
			}
			printCountingMap.put("idx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("idref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREF));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREF), element));
				out.print(" ");
			}
			printCountingMap.put("idref", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("idrefx");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREFX));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__IDREFX), element));
				out.print(" ");
			}
			printCountingMap.put("idrefx", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("relation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION));
			if (o != null) {
				ASPT.resource.aspt.IAsptTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPT.ASPTPackage.TRACE_LINK__RELATION), element));
				out.print(" ");
			}
			printCountingMap.put("relation", count - 1);
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
