/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.mopp;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class AsptAttributeValueProvider {
	
	public Object[] getDefaultValues(org.eclipse.emf.ecore.EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + ASPT.resource.aspt.util.AsptStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
