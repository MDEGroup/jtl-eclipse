/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

public class JtlMetaInformation implements JTL.resource.jtl.IJtlMetaInformation {
	
	public String getSyntaxName() {
		return "jtl";
	}
	
	public String getURI() {
		return "http://jtl.univaq.it/jtl";
	}
	
	public JTL.resource.jtl.IJtlTextScanner createLexer() {
		return new JTL.resource.jtl.mopp.JtlAntlrScanner(new JTL.resource.jtl.mopp.JtlLexer());
	}
	
	public JTL.resource.jtl.IJtlTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new JTL.resource.jtl.mopp.JtlParser().createInstance(inputStream, encoding);
	}
	
	public JTL.resource.jtl.IJtlTextPrinter createPrinter(java.io.OutputStream outputStream, JTL.resource.jtl.IJtlTextResource resource) {
		return new JTL.resource.jtl.mopp.JtlPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new JTL.resource.jtl.mopp.JtlSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new JTL.resource.jtl.mopp.JtlSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public JTL.resource.jtl.IJtlReferenceResolverSwitch getReferenceResolverSwitch() {
		return new JTL.resource.jtl.mopp.JtlReferenceResolverSwitch();
	}
	
	public JTL.resource.jtl.IJtlTokenResolverFactory getTokenResolverFactory() {
		return new JTL.resource.jtl.mopp.JtlTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "JTL.emftext.JTL/metamodel/JTL.cs";
	}
	
	public String[] getTokenNames() {
		return JTL.resource.jtl.mopp.JtlParser.tokenNames;
	}
	
	public JTL.resource.jtl.IJtlTokenStyle getDefaultTokenStyle(String tokenName) {
		return new JTL.resource.jtl.mopp.JtlTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<JTL.resource.jtl.IJtlBracketPair> getBracketPairs() {
		return new JTL.resource.jtl.mopp.JtlBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new JTL.resource.jtl.mopp.JtlFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new JTL.resource.jtl.mopp.JtlResourceFactory();
	}
	
	public JTL.resource.jtl.mopp.JtlNewFileContentProvider getNewFileContentProvider() {
		return new JTL.resource.jtl.mopp.JtlNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new JTL.resource.jtl.mopp.JtlResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "JTL.resource.jtl.ui.launchConfigurationType";
	}
	
	public JTL.resource.jtl.IJtlNameProvider createNameProvider() {
		return new JTL.resource.jtl.analysis.JtlDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		JTL.resource.jtl.mopp.JtlAntlrTokenHelper tokenHelper = new JTL.resource.jtl.mopp.JtlAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(JTL.resource.jtl.mopp.JtlTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
