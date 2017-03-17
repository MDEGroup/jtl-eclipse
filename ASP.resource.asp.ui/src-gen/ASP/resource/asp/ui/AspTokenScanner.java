/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class AspTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private ASP.resource.asp.IAspTextScanner lexer;
	private ASP.resource.asp.IAspTextToken currentToken;
	private java.util.List<ASP.resource.asp.IAspTextToken> nextTokens;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private ASP.resource.asp.ui.AspColorManager colorManager;
	private ASP.resource.asp.IAspTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public AspTokenScanner(ASP.resource.asp.IAspTextResource resource, ASP.resource.asp.ui.AspColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new ASP.resource.asp.mopp.AspMetaInformation().createLexer();
		this.languageId = new ASP.resource.asp.mopp.AspMetaInformation().getSyntaxName();
		ASP.resource.asp.ui.AspUIPlugin plugin = ASP.resource.asp.ui.AspUIPlugin.getDefault();
		if (plugin != null) {
			this.store = plugin.getPreferenceStore();
		}
		this.nextTokens = new java.util.ArrayList<ASP.resource.asp.IAspTextToken>();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		boolean isOriginalToken = true;
		if (!nextTokens.isEmpty()) {
			currentToken = nextTokens.remove(0);
			isOriginalToken = false;
		} else {
			currentToken = lexer.getNextToken();
		}
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		
		if (isOriginalToken) {
			splitCurrentToken();
		}
		
		org.eclipse.jface.text.TextAttribute textAttribute = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			ASP.resource.asp.IAspTokenStyle staticStyle = getStaticTokenStyle();
			// now call dynamic token styler to allow to apply modifications to the static
			// style
			ASP.resource.asp.IAspTokenStyle dynamicStyle = getDynamicTokenStyle(staticStyle);
			if (dynamicStyle != null) {
				textAttribute = getTextAttribute(dynamicStyle);
			}
		}
		
		return new org.eclipse.jface.text.rules.Token(textAttribute);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
	public ASP.resource.asp.IAspTokenStyle getStaticTokenStyle() {
		ASP.resource.asp.IAspTokenStyle staticStyle = null;
		String tokenName = currentToken.getName();
		String enableKey = ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.ENABLE);
		boolean enabled = store.getBoolean(enableKey);
		if (enabled) {
			String colorKey = ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.COLOR);
			org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
			org.eclipse.swt.graphics.RGB backgroundRGB = null;
			boolean bold = store.getBoolean(ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.BOLD));
			boolean italic = store.getBoolean(ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.ITALIC));
			boolean strikethrough = store.getBoolean(ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
			boolean underline = store.getBoolean(ASP.resource.asp.ui.AspSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, ASP.resource.asp.ui.AspSyntaxColoringHelper.StyleProperty.UNDERLINE));
			staticStyle = new ASP.resource.asp.mopp.AspTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
		}
		return staticStyle;
	}
	
	public ASP.resource.asp.IAspTokenStyle getDynamicTokenStyle(ASP.resource.asp.IAspTokenStyle staticStyle) {
		ASP.resource.asp.mopp.AspDynamicTokenStyler dynamicTokenStyler = new ASP.resource.asp.mopp.AspDynamicTokenStyler();
		ASP.resource.asp.IAspTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
		return dynamicStyle;
	}
	
	public org.eclipse.jface.text.TextAttribute getTextAttribute(ASP.resource.asp.IAspTokenStyle tokeStyle) {
		int[] foregroundColorArray = tokeStyle.getColorAsRGB();
		org.eclipse.swt.graphics.Color foregroundColor = null;
		if (colorManager != null) {
			foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
		}
		int[] backgroundColorArray = tokeStyle.getBackgroundColorAsRGB();
		org.eclipse.swt.graphics.Color backgroundColor = null;
		if (backgroundColorArray != null) {
			org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
			if (colorManager != null) {
				backgroundColor = colorManager.getColor(backgroundRGB);
			}
		}
		int style = org.eclipse.swt.SWT.NORMAL;
		if (tokeStyle.isBold()) {
			style = style | org.eclipse.swt.SWT.BOLD;
		}
		if (tokeStyle.isItalic()) {
			style = style | org.eclipse.swt.SWT.ITALIC;
		}
		if (tokeStyle.isStrikethrough()) {
			style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
		}
		if (tokeStyle.isUnderline()) {
			style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
		}
		return new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
	}
	
	/**
	 * Tries to split the current token if it contains task items.
	 */
	public void splitCurrentToken() {
		final String text = currentToken.getText();
		final String name = currentToken.getName();
		final int line = currentToken.getLine();
		final int charStart = currentToken.getOffset();
		final int column = currentToken.getColumn();
		
		java.util.List<ASP.resource.asp.mopp.AspTaskItem> taskItems = new ASP.resource.asp.mopp.AspTaskItemDetector().findTaskItems(text, line, charStart);
		
		// this is the offset for the next token to be added
		int offset = charStart;
		int itemBeginRelative;
		java.util.List<ASP.resource.asp.IAspTextToken> newItems = new java.util.ArrayList<ASP.resource.asp.IAspTextToken>();
		for (ASP.resource.asp.mopp.AspTaskItem taskItem : taskItems) {
			int itemBegin = taskItem.getCharStart();
			int itemLine = taskItem.getLine();
			int itemColumn = 0;
			
			itemBeginRelative = itemBegin - charStart;
			// create token before task item (TODO if required)
			String textBefore = text.substring(offset - charStart, itemBeginRelative);
			int textBeforeLength = textBefore.length();
			newItems.add(new ASP.resource.asp.mopp.AspTextToken(name, textBefore, offset, textBeforeLength, line, column, true));
			
			// create token for the task item itself
			offset = offset + textBeforeLength;
			String itemText = taskItem.getKeyword();
			int itemTextLength = itemText.length();
			newItems.add(new ASP.resource.asp.mopp.AspTextToken(ASP.resource.asp.mopp.AspTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME, itemText, offset, itemTextLength, itemLine, itemColumn, true));
			
			offset = offset + itemTextLength;
		}
		
		if (!taskItems.isEmpty()) {
			// create token after last task item (TODO if required)
			String textAfter = text.substring(offset - charStart);
			newItems.add(new ASP.resource.asp.mopp.AspTextToken(name, textAfter, offset, textAfter.length(), line, column, true));
		}
		
		if (!newItems.isEmpty()) {
			// replace tokens
			currentToken = newItems.remove(0);
			nextTokens = newItems;
		}
		
	}
}
