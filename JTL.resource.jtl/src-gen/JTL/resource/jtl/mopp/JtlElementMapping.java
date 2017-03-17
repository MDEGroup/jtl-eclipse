/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.mopp;

/**
 * A basic implementation of the JTL.resource.jtl.IJtlElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class JtlElementMapping<ReferenceType> implements JTL.resource.jtl.IJtlElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public JtlElementMapping(String identifier, ReferenceType target, String warning) {
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
