/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IJtlElementMapping<ReferenceType> extends JTL.resource.jtl.IJtlReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
