/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private JTL.resource.jtl.IJtlResourceProvider resourceProvider;
	private JTL.resource.jtl.ui.IJtlBracketHandlerProvider bracketHandlerProvider;
	
	public JtlCompletionProcessor(JTL.resource.jtl.IJtlResourceProvider resourceProvider, JTL.resource.jtl.ui.IJtlBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		JTL.resource.jtl.IJtlTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		JTL.resource.jtl.ui.JtlCodeCompletionHelper helper = new JTL.resource.jtl.ui.JtlCodeCompletionHelper();
		JTL.resource.jtl.ui.JtlCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		JTL.resource.jtl.ui.JtlProposalPostProcessor proposalPostProcessor = new JTL.resource.jtl.ui.JtlProposalPostProcessor();
		java.util.List<JTL.resource.jtl.ui.JtlCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<JTL.resource.jtl.ui.JtlCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<JTL.resource.jtl.ui.JtlCompletionProposal> finalProposalList = new java.util.ArrayList<JTL.resource.jtl.ui.JtlCompletionProposal>();
		for (JTL.resource.jtl.ui.JtlCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (JTL.resource.jtl.ui.JtlCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			JTL.resource.jtl.ui.IJtlBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
