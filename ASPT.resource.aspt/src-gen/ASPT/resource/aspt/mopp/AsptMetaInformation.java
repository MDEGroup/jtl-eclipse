/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

public class AsptMetaInformation implements ASPT.resource.aspt.IAsptMetaInformation {
	
	public String getSyntaxName() {
		return "aspt";
	}
	
	public String getURI() {
		return "http://jtl.univaq.it/aspt";
	}
	
	public ASPT.resource.aspt.IAsptTextScanner createLexer() {
		return new ASPT.resource.aspt.mopp.AsptAntlrScanner(new ASPT.resource.aspt.mopp.AsptLexer());
	}
	
	public ASPT.resource.aspt.IAsptTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new ASPT.resource.aspt.mopp.AsptParser().createInstance(inputStream, encoding);
	}
	
	public ASPT.resource.aspt.IAsptTextPrinter createPrinter(java.io.OutputStream outputStream, ASPT.resource.aspt.IAsptTextResource resource) {
		return new ASPT.resource.aspt.mopp.AsptPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new ASPT.resource.aspt.mopp.AsptSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new ASPT.resource.aspt.mopp.AsptSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public ASPT.resource.aspt.IAsptReferenceResolverSwitch getReferenceResolverSwitch() {
		return new ASPT.resource.aspt.mopp.AsptReferenceResolverSwitch();
	}
	
	public ASPT.resource.aspt.IAsptTokenResolverFactory getTokenResolverFactory() {
		return new ASPT.resource.aspt.mopp.AsptTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "JTL.emftext.ASPT/metamodel/ASPT.cs";
	}
	
	public String[] getTokenNames() {
		return ASPT.resource.aspt.mopp.AsptParser.tokenNames;
	}
	
	public ASPT.resource.aspt.IAsptTokenStyle getDefaultTokenStyle(String tokenName) {
		return new ASPT.resource.aspt.mopp.AsptTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<ASPT.resource.aspt.IAsptBracketPair> getBracketPairs() {
		return new ASPT.resource.aspt.mopp.AsptBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new ASPT.resource.aspt.mopp.AsptFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new ASPT.resource.aspt.mopp.AsptResourceFactory();
	}
	
	public ASPT.resource.aspt.mopp.AsptNewFileContentProvider getNewFileContentProvider() {
		return new ASPT.resource.aspt.mopp.AsptNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new ASPT.resource.aspt.mopp.AsptResourceFactory());
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
		return "ASPT.resource.aspt.ui.launchConfigurationType";
	}
	
	public ASPT.resource.aspt.IAsptNameProvider createNameProvider() {
		return new ASPT.resource.aspt.analysis.AsptDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		ASPT.resource.aspt.mopp.AsptAntlrTokenHelper tokenHelper = new ASPT.resource.aspt.mopp.AsptAntlrTokenHelper();
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
		highlightableTokens.add(ASPT.resource.aspt.mopp.AsptTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
