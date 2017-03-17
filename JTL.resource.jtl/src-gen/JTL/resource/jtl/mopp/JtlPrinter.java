/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlPrinter implements JTL.resource.jtl.IJtlTextPrinter {
	
	protected JTL.resource.jtl.IJtlTokenResolverFactory tokenResolverFactory = new JTL.resource.jtl.mopp.JtlTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private JTL.resource.jtl.IJtlTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public JtlPrinter(java.io.OutputStream outputStream, JTL.resource.jtl.IJtlTextResource resource) {
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
		
		if (element instanceof JTL.JTL.Transformation) {
			print_JTL_JTL_Transformation((JTL.JTL.Transformation) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Model) {
			print_JTL_JTL_Model((JTL.JTL.Model) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Relation) {
			print_JTL_JTL_Relation((JTL.JTL.Relation) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Domain) {
			print_JTL_JTL_Domain((JTL.JTL.Domain) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.When) {
			print_JTL_JTL_When((JTL.JTL.When) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Where) {
			print_JTL_JTL_Where((JTL.JTL.Where) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Predicate) {
			print_JTL_JTL_Predicate((JTL.JTL.Predicate) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.template.ObjectTemplateExp) {
			print_JTL_template_ObjectTemplateExp((JTL.template.ObjectTemplateExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.imperativeocl.AssignExp) {
			print_JTL_imperativeocl_AssignExp((JTL.imperativeocl.AssignExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.essentialocl.OperationCallExp) {
			print_JTL_essentialocl_OperationCallExp((JTL.essentialocl.OperationCallExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.essentialocl.BooleanLiteralExp) {
			print_JTL_essentialocl_BooleanLiteralExp((JTL.essentialocl.BooleanLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.essentialocl.VariableExp) {
			print_JTL_essentialocl_VariableExp((JTL.essentialocl.VariableExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.essentialocl.StringLiteralExp) {
			print_JTL_essentialocl_StringLiteralExp((JTL.essentialocl.StringLiteralExp) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.essentialocl.Variable) {
			print_JTL_essentialocl_Variable((JTL.essentialocl.Variable) element, globaltab, out);
			return;
		}
		if (element instanceof JTL.JTL.Pattern) {
			print_JTL_JTL_Pattern((JTL.JTL.Pattern) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected JTL.resource.jtl.mopp.JtlReferenceResolverSwitch getReferenceResolverSwitch() {
		return (JTL.resource.jtl.mopp.JtlReferenceResolverSwitch) new JTL.resource.jtl.mopp.JtlMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		JTL.resource.jtl.IJtlTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new JTL.resource.jtl.mopp.JtlProblem(errorMessage, JTL.resource.jtl.JtlEProblemType.PRINT_PROBLEM, JTL.resource.jtl.JtlEProblemSeverity.WARNING), cause);
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
	
	public JTL.resource.jtl.IJtlTextResource getResource() {
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
	
	public void print_JTL_JTL_Transformation(JTL.JTL.Transformation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(13);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__PACKAGE));
		printCountingMap.put("package", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__OWNED_ATTRIBUTE));
		printCountingMap.put("ownedAttribute", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__OWNED_OPERATION));
		printCountingMap.put("ownedOperation", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__SUPER_CLASS));
		printCountingMap.put("superClass", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__IS_ABSTRACT));
		printCountingMap.put("isAbstract", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__OWNED_TYPE));
		printCountingMap.put("ownedType", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NESTED_PACKAGE));
		printCountingMap.put("nestedPackage", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__URI));
		printCountingMap.put("uri", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER));
		printCountingMap.put("modelParameter", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__RELATION));
		printCountingMap.put("relation", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("transformation");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_JTL_Transformation_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_JTL_JTL_Transformation_1(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Transformation_1(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_JTL_JTL_Transformation_0(JTL.JTL.Transformation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("modelParameter");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER));
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
			printCountingMap.put("modelParameter", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Transformation_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_JTL_JTL_Transformation_0_0(JTL.JTL.Transformation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("modelParameter");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__MODEL_PARAMETER));
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
			printCountingMap.put("modelParameter", count - 1);
		}
	}
	
	public void print_JTL_JTL_Transformation_1(JTL.JTL.Transformation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("relation");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.TRANSFORMATION__RELATION));
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
			printCountingMap.put("relation", count - 1);
		}
	}
	
	
	public void print_JTL_JTL_Model(JTL.JTL.Model element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__DEPENDS_ON));
		printCountingMap.put("dependsOn", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE));
		printCountingMap.put("usedPackage", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("usedPackage");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.MODEL__USED_PACKAGE), element));
				out.print(" ");
			}
			printCountingMap.put("usedPackage", count - 1);
		}
	}
	
	
	public void print_JTL_JTL_Relation(JTL.JTL.Relation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__TRANSFORMATION));
		printCountingMap.put("transformation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__DOMAIN));
		printCountingMap.put("domain", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHERE));
		printCountingMap.put("where", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHEN));
		printCountingMap.put("when", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL));
		printCountingMap.put("isTopLevel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__VARIABLE));
		printCountingMap.put("variable", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isTopLevel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__IS_TOP_LEVEL));
			if (o != null) {
			}
			printCountingMap.put("isTopLevel", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("relation");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Relation_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Relation_1(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_JTL_Relation_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_JTL_Relation_3(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_JTL_JTL_Relation_0(JTL.JTL.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("variable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__VARIABLE));
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
			printCountingMap.put("variable", count - 1);
		}
	}
	
	public void print_JTL_JTL_Relation_1(JTL.JTL.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("domain");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__DOMAIN));
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
			printCountingMap.put("domain", count - 1);
		}
	}
	
	public void print_JTL_JTL_Relation_2(JTL.JTL.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("when");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHEN));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("when", count - 1);
		}
	}
	
	public void print_JTL_JTL_Relation_3(JTL.JTL.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("where");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.RELATION__WHERE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("where", count - 1);
		}
	}
	
	
	public void print_JTL_JTL_Domain(JTL.JTL.Domain element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE));
		printCountingMap.put("isCheckable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE));
		printCountingMap.put("isEnforceable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__RELATION));
		printCountingMap.put("relation", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__PATTERN));
		printCountingMap.put("pattern", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__MODEL));
		printCountingMap.put("model", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__ROOT_VARIABLE));
		printCountingMap.put("rootVariable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isCheckable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_CHECKABLE));
			if (o != null) {
			}
			printCountingMap.put("isCheckable", count - 1);
		}
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("isEnforceable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__IS_ENFORCEABLE));
			if (o != null) {
			}
			printCountingMap.put("isEnforceable", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("domain");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pattern");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.DOMAIN__PATTERN));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pattern", count - 1);
		}
	}
	
	
	public void print_JTL_JTL_Pattern(JTL.JTL.Pattern element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__PREDICATE));
		printCountingMap.put("predicate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__BINDS_TO));
		printCountingMap.put("bindsTo", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__TEMPLATE_EXPRESSION));
		printCountingMap.put("templateExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__DOMAIN));
		printCountingMap.put("domain", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("templateExpression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__TEMPLATE_EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("templateExpression", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_JTL_Pattern_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("};");
		out.print(" ");
	}
	
	public void print_JTL_JTL_Pattern_0(JTL.JTL.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("predicate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__PREDICATE));
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
			printCountingMap.put("predicate", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Pattern_0_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_JTL_JTL_Pattern_0_0(JTL.JTL.Pattern element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("predicate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PATTERN__PREDICATE));
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
			printCountingMap.put("predicate", count - 1);
		}
	}
	
	
	public void print_JTL_JTL_When(JTL.JTL.When element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__PREDICATE));
		printCountingMap.put("predicate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__BINDS_TO));
		printCountingMap.put("bindsTo", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__TEMPLATE_EXPRESSION));
		printCountingMap.put("templateExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__DOMAIN));
		printCountingMap.put("domain", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__WHEN_OWNER));
		printCountingMap.put("whenOwner", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("when");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_When_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_JTL_JTL_When_0(JTL.JTL.When element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("predicate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHEN__PREDICATE));
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
			printCountingMap.put("predicate", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_JTL_JTL_Where(JTL.JTL.Where element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__PREDICATE));
		printCountingMap.put("predicate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__BINDS_TO));
		printCountingMap.put("bindsTo", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__TEMPLATE_EXPRESSION));
		printCountingMap.put("templateExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__DOMAIN));
		printCountingMap.put("domain", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__WHERE_OWNER));
		printCountingMap.put("whereOwner", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("where");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_JTL_Where_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_JTL_JTL_Where_0(JTL.JTL.Where element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("predicate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.WHERE__PREDICATE));
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
			printCountingMap.put("predicate", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	
	public void print_JTL_JTL_Predicate(JTL.JTL.Predicate element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__PATTERN));
		printCountingMap.put("pattern", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__CONDITION_EXPRESSION));
		printCountingMap.put("conditionExpression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("conditionExpression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.JTL.JTLPackage.PREDICATE__CONDITION_EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("conditionExpression", count - 1);
		}
	}
	
	
	public void print_JTL_template_ObjectTemplateExp(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(10);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__BINDS_TO));
		printCountingMap.put("bindsTo", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__WHERE));
		printCountingMap.put("where", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__PART));
		printCountingMap.put("part", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS));
		printCountingMap.put("referredClass", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE));
		printCountingMap.put("inside", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_template_ObjectTemplateExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_template_ObjectTemplateExp_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_template_ObjectTemplateExp_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_JTL_template_ObjectTemplateExp_0(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	public void print_JTL_template_ObjectTemplateExp_1(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("::");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("referredClass");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS), element));
				out.print(" ");
			}
			printCountingMap.put("referredClass", count - 1);
		}
	}
	
	public void print_JTL_template_ObjectTemplateExp_2(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_template_ObjectTemplateExp_2_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_JTL_template_ObjectTemplateExp_2_0(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("inside");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE));
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
			printCountingMap.put("inside", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_template_ObjectTemplateExp_2_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_JTL_template_ObjectTemplateExp_2_0_0(JTL.template.ObjectTemplateExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("inside");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.template.TemplatePackage.OBJECT_TEMPLATE_EXP__INSIDE));
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
			printCountingMap.put("inside", count - 1);
		}
	}
	
	
	public void print_JTL_imperativeocl_AssignExp(JTL.imperativeocl.AssignExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__VALUE));
		printCountingMap.put("value", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__LEFT));
		printCountingMap.put("left", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__DEFAULT_VALUE));
		printCountingMap.put("defaultValue", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__IS_RESET));
		printCountingMap.put("isReset", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("value");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(JTL.imperativeocl.ImperativeoclPackage.ASSIGN_EXP__VALUE));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("value", 0);
		}
	}
	
	
	public void print_JTL_essentialocl_OperationCallExp(JTL.essentialocl.OperationCallExp element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT));
		printCountingMap.put("argument", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__REFERRED_OPERATION));
		printCountingMap.put("referredOperation", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_essentialocl_OperationCallExp_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	public void print_JTL_essentialocl_OperationCallExp_0(JTL.essentialocl.OperationCallExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("argument");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT));
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
			printCountingMap.put("argument", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_JTL_essentialocl_OperationCallExp_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_JTL_essentialocl_OperationCallExp_0_0(JTL.essentialocl.OperationCallExp element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("argument");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.OPERATION_CALL_EXP__ARGUMENT));
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
			printCountingMap.put("argument", count - 1);
		}
	}
	
	
	public void print_JTL_essentialocl_BooleanLiteralExp(JTL.essentialocl.BooleanLiteralExp element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL));
		printCountingMap.put("booleanSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("booleanSymbol");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL));
			if (o != null) {
			}
			printCountingMap.put("booleanSymbol", count - 1);
		}
	}
	
	
	public void print_JTL_essentialocl_VariableExp(JTL.essentialocl.VariableExp element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__REFERRED_VARIABLE));
		printCountingMap.put("referredVariable", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE_EXP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
	}
	
	
	public void print_JTL_essentialocl_StringLiteralExp(JTL.essentialocl.StringLiteralExp element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__TRY_BODY_OWNER));
		printCountingMap.put("tryBodyOwner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__STRING_SYMBOL));
		printCountingMap.put("stringSymbol", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("|");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.STRING_LITERAL_EXP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("|");
		out.print(" ");
	}
	
	
	public void print_JTL_essentialocl_Variable(JTL.essentialocl.Variable element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TAG));
		printCountingMap.put("tag", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__OWNED_COMMENT));
		printCountingMap.put("ownedComment", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__INIT_EXPRESSION));
		printCountingMap.put("initExpression", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__LET_EXP));
		printCountingMap.put("LetExp", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__BIND_PARAMETER));
		printCountingMap.put("bindParameter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__COMPUTE_OWNER));
		printCountingMap.put("computeOwner", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_JTL_essentialocl_Variable_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
	}
	
	public void print_JTL_essentialocl_Variable_0(JTL.essentialocl.Variable element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE));
			if (o != null) {
				JTL.resource.jtl.IJtlTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(JTL.essentialocl.EssentialoclPackage.VARIABLE__TYPE), element));
				out.print(" ");
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
}
