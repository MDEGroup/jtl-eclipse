/**
 * <copyright>
 * </copyright>
 *
 *
 */
package ASPM.resource.aspm.analysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AspmQUOTED_34_34_92TokenResolver implements ASPM.resource.aspm.IAspmTokenResolver {

	private ASPM.resource.aspm.analysis.AspmDefaultTokenResolver defaultTokenResolver = new ASPM.resource.aspm.analysis.AspmDefaultTokenResolver(true);
	private Pattern listPattern = Pattern.compile("\\w+\\(\\[[^,]+(,[^,]+)+\\]\\)");

	@Override
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result;
		if (isList(value)) {
			result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		} else {
			result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", "\\");
		}
		return result;
	}

	@Override
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ASPM.resource.aspm.IAspmTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", "\\");
	}

	@Override
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}

	private boolean isList(final Object value) {
		if (value == null) {
			return false;
		}
		Matcher m = listPattern.matcher(value.toString());
		return m.matches();
	}

}
