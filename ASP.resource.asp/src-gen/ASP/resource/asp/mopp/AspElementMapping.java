/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.mopp;

/**
 * A basic implementation of the ASP.resource.asp.IAspElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class AspElementMapping<ReferenceType> implements ASP.resource.asp.IAspElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public AspElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
