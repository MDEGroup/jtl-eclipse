/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

public class AspmmMetaInformation implements ASPMM.resource.aspmm.IAspmmMetaInformation {
	
	public String getSyntaxName() {
		return "aspmm";
	}
	
	public String getURI() {
		return "http://jtl.univaq.it/aspmm";
	}
	
	public ASPMM.resource.aspmm.IAspmmTextScanner createLexer() {
		return new ASPMM.resource.aspmm.mopp.AspmmAntlrScanner(new ASPMM.resource.aspmm.mopp.AspmmLexer());
	}
	
	public ASPMM.resource.aspmm.IAspmmTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new ASPMM.resource.aspmm.mopp.AspmmParser().createInstance(inputStream, encoding);
	}
	
	public ASPMM.resource.aspmm.IAspmmTextPrinter createPrinter(java.io.OutputStream outputStream, ASPMM.resource.aspmm.IAspmmTextResource resource) {
		return new ASPMM.resource.aspmm.mopp.AspmmPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new ASPMM.resource.aspmm.mopp.AspmmSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new ASPMM.resource.aspmm.mopp.AspmmSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public ASPMM.resource.aspmm.IAspmmReferenceResolverSwitch getReferenceResolverSwitch() {
		return new ASPMM.resource.aspmm.mopp.AspmmReferenceResolverSwitch();
	}
	
	public ASPMM.resource.aspmm.IAspmmTokenResolverFactory getTokenResolverFactory() {
		return new ASPMM.resource.aspmm.mopp.AspmmTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "JTL.emftext.ASPMM/metamodel/ASPMM.cs";
	}
	
	public String[] getTokenNames() {
		return ASPMM.resource.aspmm.mopp.AspmmParser.tokenNames;
	}
	
	public ASPMM.resource.aspmm.IAspmmTokenStyle getDefaultTokenStyle(String tokenName) {
		return new ASPMM.resource.aspmm.mopp.AspmmTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<ASPMM.resource.aspmm.IAspmmBracketPair> getBracketPairs() {
		return new ASPMM.resource.aspmm.mopp.AspmmBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new ASPMM.resource.aspmm.mopp.AspmmFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new ASPMM.resource.aspmm.mopp.AspmmResourceFactory();
	}
	
	public ASPMM.resource.aspmm.mopp.AspmmNewFileContentProvider getNewFileContentProvider() {
		return new ASPMM.resource.aspmm.mopp.AspmmNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new ASPMM.resource.aspmm.mopp.AspmmResourceFactory());
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
		return "ASPMM.resource.aspmm.ui.launchConfigurationType";
	}
	
	public ASPMM.resource.aspmm.IAspmmNameProvider createNameProvider() {
		return new ASPMM.resource.aspmm.analysis.AspmmDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		ASPMM.resource.aspmm.mopp.AspmmAntlrTokenHelper tokenHelper = new ASPMM.resource.aspmm.mopp.AspmmAntlrTokenHelper();
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
		highlightableTokens.add(ASPMM.resource.aspmm.mopp.AspmmTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
