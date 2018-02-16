/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class AsptProposalPostProcessor {
	
	public java.util.List<ASPT.resource.aspt.ui.AsptCompletionProposal> process(java.util.List<ASPT.resource.aspt.ui.AsptCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
