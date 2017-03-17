/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

public class AspmMetaInformation implements ASPM.resource.aspm.IAspmMetaInformation {
	
	public String getSyntaxName() {
		return "aspm";
	}
	
	public String getURI() {
		return "http://jtl.univaq.it/aspm";
	}
	
	public ASPM.resource.aspm.IAspmTextScanner createLexer() {
		return new ASPM.resource.aspm.mopp.AspmAntlrScanner(new ASPM.resource.aspm.mopp.AspmLexer());
	}
	
	public ASPM.resource.aspm.IAspmTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new ASPM.resource.aspm.mopp.AspmParser().createInstance(inputStream, encoding);
	}
	
	public ASPM.resource.aspm.IAspmTextPrinter createPrinter(java.io.OutputStream outputStream, ASPM.resource.aspm.IAspmTextResource resource) {
		return new ASPM.resource.aspm.mopp.AspmPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new ASPM.resource.aspm.mopp.AspmSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new ASPM.resource.aspm.mopp.AspmSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public ASPM.resource.aspm.IAspmReferenceResolverSwitch getReferenceResolverSwitch() {
		return new ASPM.resource.aspm.mopp.AspmReferenceResolverSwitch();
	}
	
	public ASPM.resource.aspm.IAspmTokenResolverFactory getTokenResolverFactory() {
		return new ASPM.resource.aspm.mopp.AspmTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "JTL.emftext.ASPM/metamodel/ASPM.cs";
	}
	
	public String[] getTokenNames() {
		return ASPM.resource.aspm.mopp.AspmParser.tokenNames;
	}
	
	public ASPM.resource.aspm.IAspmTokenStyle getDefaultTokenStyle(String tokenName) {
		return new ASPM.resource.aspm.mopp.AspmTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<ASPM.resource.aspm.IAspmBracketPair> getBracketPairs() {
		return new ASPM.resource.aspm.mopp.AspmBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new ASPM.resource.aspm.mopp.AspmFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new ASPM.resource.aspm.mopp.AspmResourceFactory();
	}
	
	public ASPM.resource.aspm.mopp.AspmNewFileContentProvider getNewFileContentProvider() {
		return new ASPM.resource.aspm.mopp.AspmNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new ASPM.resource.aspm.mopp.AspmResourceFactory());
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
		return "ASPM.resource.aspm.ui.launchConfigurationType";
	}
	
	public ASPM.resource.aspm.IAspmNameProvider createNameProvider() {
		return new ASPM.resource.aspm.analysis.AspmDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		ASPM.resource.aspm.mopp.AspmAntlrTokenHelper tokenHelper = new ASPM.resource.aspm.mopp.AspmAntlrTokenHelper();
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
		highlightableTokens.add(ASPM.resource.aspm.mopp.AspmTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
