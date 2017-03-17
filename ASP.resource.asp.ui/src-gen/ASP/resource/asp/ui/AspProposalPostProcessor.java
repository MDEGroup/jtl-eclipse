/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class AspProposalPostProcessor {
	
	public java.util.List<ASP.resource.asp.ui.AspCompletionProposal> process(java.util.List<ASP.resource.asp.ui.AspCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
