/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class AspmCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
