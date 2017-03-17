/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class JtlProposalPostProcessor {
	
	public java.util.List<JTL.resource.jtl.ui.JtlCompletionProposal> process(java.util.List<JTL.resource.jtl.ui.JtlCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
