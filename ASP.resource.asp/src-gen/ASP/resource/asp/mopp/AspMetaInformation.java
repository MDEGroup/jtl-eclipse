/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

public class AspMetaInformation implements ASP.resource.asp.IAspMetaInformation {
	
	public String getSyntaxName() {
		return "asp";
	}
	
	public String getURI() {
		return "http://jtl.univaq.it/asp";
	}
	
	public ASP.resource.asp.IAspTextScanner createLexer() {
		return new ASP.resource.asp.mopp.AspAntlrScanner(new ASP.resource.asp.mopp.AspLexer());
	}
	
	public ASP.resource.asp.IAspTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new ASP.resource.asp.mopp.AspParser().createInstance(inputStream, encoding);
	}
	
	public ASP.resource.asp.IAspTextPrinter createPrinter(java.io.OutputStream outputStream, ASP.resource.asp.IAspTextResource resource) {
		return new ASP.resource.asp.mopp.AspPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new ASP.resource.asp.mopp.AspSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new ASP.resource.asp.mopp.AspSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public ASP.resource.asp.IAspReferenceResolverSwitch getReferenceResolverSwitch() {
		return new ASP.resource.asp.mopp.AspReferenceResolverSwitch();
	}
	
	public ASP.resource.asp.IAspTokenResolverFactory getTokenResolverFactory() {
		return new ASP.resource.asp.mopp.AspTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "JTL.emftext.ASP/metamodel/ASP.cs";
	}
	
	public String[] getTokenNames() {
		return ASP.resource.asp.mopp.AspParser.tokenNames;
	}
	
	public ASP.resource.asp.IAspTokenStyle getDefaultTokenStyle(String tokenName) {
		return new ASP.resource.asp.mopp.AspTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<ASP.resource.asp.IAspBracketPair> getBracketPairs() {
		return new ASP.resource.asp.mopp.AspBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new ASP.resource.asp.mopp.AspFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new ASP.resource.asp.mopp.AspResourceFactory();
	}
	
	public ASP.resource.asp.mopp.AspNewFileContentProvider getNewFileContentProvider() {
		return new ASP.resource.asp.mopp.AspNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new ASP.resource.asp.mopp.AspResourceFactory());
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
		return "ASP.resource.asp.ui.launchConfigurationType";
	}
	
	public ASP.resource.asp.IAspNameProvider createNameProvider() {
		return new ASP.resource.asp.analysis.AspDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		ASP.resource.asp.mopp.AspAntlrTokenHelper tokenHelper = new ASP.resource.asp.mopp.AspAntlrTokenHelper();
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
		highlightableTokens.add(ASP.resource.asp.mopp.AspTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
