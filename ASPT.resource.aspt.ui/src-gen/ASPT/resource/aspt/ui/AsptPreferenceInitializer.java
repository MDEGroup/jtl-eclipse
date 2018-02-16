/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

/**
 * A class used to initialize default preference values.
 */
public class AsptPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = ASPT.resource.aspt.ui.AsptUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(ASPT.resource.aspt.ui.AsptPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(ASPT.resource.aspt.ui.AsptPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = ASPT.resource.aspt.ui.AsptUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new ASPT.resource.aspt.mopp.AsptMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = ASPT.resource.aspt.ui.AsptUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new ASPT.resource.aspt.mopp.AsptMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, ASPT.resource.aspt.IAsptMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		ASPT.resource.aspt.ui.AsptBracketSet bracketSet = new ASPT.resource.aspt.ui.AsptBracketSet(null, null);
		final java.util.Collection<ASPT.resource.aspt.IAsptBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (ASPT.resource.aspt.IAsptBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + ASPT.resource.aspt.ui.AsptPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, ASPT.resource.aspt.mopp.AsptMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			ASPT.resource.aspt.IAsptTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPT.resource.aspt.ui.AsptSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
