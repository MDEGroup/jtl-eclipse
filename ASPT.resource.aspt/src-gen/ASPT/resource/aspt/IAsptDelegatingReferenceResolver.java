/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see ASPT.resource.aspt.IAsptOptions
 */
public interface IAsptDelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends ASPT.resource.aspt.IAsptReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(ASPT.resource.aspt.IAsptReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
