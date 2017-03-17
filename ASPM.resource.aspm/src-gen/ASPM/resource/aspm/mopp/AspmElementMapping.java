/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

/**
 * A basic implementation of the ASPM.resource.aspm.IAspmElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class AspmElementMapping<ReferenceType> implements ASPM.resource.aspm.IAspmElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public AspmElementMapping(String identifier, ReferenceType target, String warning) {
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
