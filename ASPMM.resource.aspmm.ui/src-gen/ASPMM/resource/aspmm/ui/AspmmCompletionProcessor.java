/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private ASPMM.resource.aspmm.IAspmmResourceProvider resourceProvider;
	private ASPMM.resource.aspmm.ui.IAspmmBracketHandlerProvider bracketHandlerProvider;
	
	public AspmmCompletionProcessor(ASPMM.resource.aspmm.IAspmmResourceProvider resourceProvider, ASPMM.resource.aspmm.ui.IAspmmBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		ASPMM.resource.aspmm.IAspmmTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new org.eclipse.jface.text.contentassist.ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		ASPMM.resource.aspmm.ui.AspmmCodeCompletionHelper helper = new ASPMM.resource.aspmm.ui.AspmmCodeCompletionHelper();
		ASPMM.resource.aspmm.ui.AspmmCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		ASPMM.resource.aspmm.ui.AspmmProposalPostProcessor proposalPostProcessor = new ASPMM.resource.aspmm.ui.AspmmProposalPostProcessor();
		java.util.List<ASPMM.resource.aspmm.ui.AspmmCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<ASPMM.resource.aspmm.ui.AspmmCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<ASPMM.resource.aspmm.ui.AspmmCompletionProposal> finalProposalList = new java.util.ArrayList<ASPMM.resource.aspmm.ui.AspmmCompletionProposal>();
		for (ASPMM.resource.aspmm.ui.AspmmCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (ASPMM.resource.aspmm.ui.AspmmCompletionProposal proposal : finalProposalList) {
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
			ASPMM.resource.aspmm.ui.IAspmmBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
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
