/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class AspmProposalPostProcessor {
	
	public java.util.List<ASPM.resource.aspm.ui.AspmCompletionProposal> process(java.util.List<ASPM.resource.aspm.ui.AspmCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
