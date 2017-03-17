/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmPrinter implements ASPMM.resource.aspmm.IAspmmTextPrinter {
	
	protected ASPMM.resource.aspmm.IAspmmTokenResolverFactory tokenResolverFactory = new ASPMM.resource.aspmm.mopp.AspmmTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private ASPMM.resource.aspmm.IAspmmTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public AspmmPrinter(java.io.OutputStream outputStream, ASPMM.resource.aspmm.IAspmmTextResource resource) {
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
		
		if (element instanceof ASPMM.Metamodel) {
			print_ASPMM_Metamodel((ASPMM.Metamodel) element, globaltab, out);
			return;
		}
		if (element instanceof ASPMM.Metanode) {
			print_ASPMM_Metanode((ASPMM.Metanode) element, globaltab, out);
			return;
		}
		if (element instanceof ASPMM.Metaprop) {
			print_ASPMM_Metaprop((ASPMM.Metaprop) element, globaltab, out);
			return;
		}
		if (element instanceof ASPMM.Metaedge) {
			print_ASPMM_Metaedge((ASPMM.Metaedge) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected ASPMM.resource.aspmm.mopp.AspmmReferenceResolverSwitch getReferenceResolverSwitch() {
		return (ASPMM.resource.aspmm.mopp.AspmmReferenceResolverSwitch) new ASPMM.resource.aspmm.mopp.AspmmMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		ASPMM.resource.aspmm.IAspmmTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new ASPMM.resource.aspmm.mopp.AspmmProblem(errorMessage, ASPMM.resource.aspmm.AspmmEProblemType.PRINT_PROBLEM, ASPMM.resource.aspmm.AspmmEProblemSeverity.WARNING), cause);
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
	
	public ASPMM.resource.aspmm.IAspmmTextResource getResource() {
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
	
	public void print_ASPMM_Metamodel(ASPMM.Metamodel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METANODES));
		printCountingMap.put("metanodes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAEDGES));
		printCountingMap.put("metaedges", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAPROPS));
		printCountingMap.put("metaprops", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metamodel");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__NAME), element));
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
		count = printCountingMap.get("metanodes");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METANODES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("metanodes", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("metaprops");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAPROPS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("metaprops", 0);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("metaedges");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAMODEL__METAEDGES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("metaedges", 0);
		}
	}
	
	
	public void print_ASPMM_Metanode(ASPMM.Metanode element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metanode");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetanodeMetamodelReferenceResolver().deResolve((ASPMM.Metamodel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METANODE__NAME), element));
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
	
	
	public void print_ASPMM_Metaprop(ASPMM.Metaprop element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE));
		printCountingMap.put("metanode", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metaprop");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetapropMetamodelReferenceResolver().deResolve((ASPMM.Metamodel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metanode");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetapropMetanodeReferenceResolver().deResolve((ASPMM.Metanode) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAPROP__METANODE), element));
				out.print(" ");
			}
			printCountingMap.put("metanode", count - 1);
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
	
	
	public void print_ASPMM_Metaedge(ASPMM.Metaedge element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__LOCATION));
		printCountingMap.put("location", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__COMMENTS_BEFORE));
		printCountingMap.put("commentsBefore", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__COMMENTS_AFTER));
		printCountingMap.put("commentsAfter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL));
		printCountingMap.put("metamodel", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("metaedge");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("metamodel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeMetamodelReferenceResolver().deResolve((ASPMM.Metamodel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__METAMODEL), element));
				out.print(" ");
			}
			printCountingMap.put("metamodel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__NAME), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeSourceReferenceResolver().deResolve((ASPMM.Metanode) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__SOURCE), element));
				out.print(" ");
			}
			printCountingMap.put("source", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET));
			if (o != null) {
				ASPMM.resource.aspmm.IAspmmTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMetaedgeTargetReferenceResolver().deResolve((ASPMM.Metanode) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET)), element.eClass().getEStructuralFeature(ASPMM.ASPMMPackage.METAEDGE__TARGET), element));
				out.print(" ");
			}
			printCountingMap.put("target", count - 1);
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
