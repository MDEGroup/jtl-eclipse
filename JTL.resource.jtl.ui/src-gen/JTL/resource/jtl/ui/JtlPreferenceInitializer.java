/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

/**
 * A class used to initialize default preference values.
 */
public class JtlPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = JTL.resource.jtl.ui.JtlUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(JTL.resource.jtl.ui.JtlPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(JTL.resource.jtl.ui.JtlPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = JTL.resource.jtl.ui.JtlUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new JTL.resource.jtl.mopp.JtlMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = JTL.resource.jtl.ui.JtlUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new JTL.resource.jtl.mopp.JtlMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, JTL.resource.jtl.IJtlMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		JTL.resource.jtl.ui.JtlBracketSet bracketSet = new JTL.resource.jtl.ui.JtlBracketSet(null, null);
		final java.util.Collection<JTL.resource.jtl.IJtlBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (JTL.resource.jtl.IJtlBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + JTL.resource.jtl.ui.JtlPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, JTL.resource.jtl.mopp.JtlMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			JTL.resource.jtl.IJtlTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(JTL.resource.jtl.ui.JtlSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, JTL.resource.jtl.ui.JtlSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
