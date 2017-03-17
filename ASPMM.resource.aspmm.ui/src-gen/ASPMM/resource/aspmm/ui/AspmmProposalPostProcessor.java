/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class AspmmProposalPostProcessor {
	
	public java.util.List<ASPMM.resource.aspmm.ui.AspmmCompletionProposal> process(java.util.List<ASPMM.resource.aspmm.ui.AspmmCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
