/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private ASPM.resource.aspm.IAspmResourceProvider resourceProvider;
	private ASPM.resource.aspm.ui.IAspmBracketHandlerProvider bracketHandlerProvider;
	
	public AspmCompletionProcessor(ASPM.resource.aspm.IAspmResourceProvider resourceProvider, ASPM.resource.aspm.ui.IAspmBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		ASPM.resource.aspm.IAspmTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		ASPM.resource.aspm.ui.AspmCodeCompletionHelper helper = new ASPM.resource.aspm.ui.AspmCodeCompletionHelper();
		ASPM.resource.aspm.ui.AspmCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		ASPM.resource.aspm.ui.AspmProposalPostProcessor proposalPostProcessor = new ASPM.resource.aspm.ui.AspmProposalPostProcessor();
		java.util.List<ASPM.resource.aspm.ui.AspmCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<ASPM.resource.aspm.ui.AspmCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<ASPM.resource.aspm.ui.AspmCompletionProposal> finalProposalList = new java.util.ArrayList<ASPM.resource.aspm.ui.AspmCompletionProposal>();
		for (ASPM.resource.aspm.ui.AspmCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (ASPM.resource.aspm.ui.AspmCompletionProposal proposal : finalProposalList) {
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
			ASPM.resource.aspm.ui.IAspmBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
