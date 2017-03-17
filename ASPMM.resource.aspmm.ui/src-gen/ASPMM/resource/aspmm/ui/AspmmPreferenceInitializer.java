/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

/**
 * A class used to initialize default preference values.
 */
public class AspmmPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = ASPMM.resource.aspmm.ui.AspmmUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = ASPMM.resource.aspmm.ui.AspmmUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new ASPMM.resource.aspmm.mopp.AspmmMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = ASPMM.resource.aspmm.ui.AspmmUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new ASPMM.resource.aspmm.mopp.AspmmMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, ASPMM.resource.aspmm.IAspmmMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		ASPMM.resource.aspmm.ui.AspmmBracketSet bracketSet = new ASPMM.resource.aspmm.ui.AspmmBracketSet(null, null);
		final java.util.Collection<ASPMM.resource.aspmm.IAspmmBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (ASPMM.resource.aspmm.IAspmmBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + ASPMM.resource.aspmm.ui.AspmmPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, ASPMM.resource.aspmm.mopp.AspmmMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			ASPMM.resource.aspmm.IAspmmTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, ASPMM.resource.aspmm.ui.AspmmSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
