/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IAspmmElementMapping<ReferenceType> extends ASPMM.resource.aspmm.IAspmmReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
