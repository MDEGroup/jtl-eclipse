/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IAspmElementMapping<ReferenceType> extends ASPM.resource.aspm.IAspmReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
