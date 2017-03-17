/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

/**
 * A manager class for the highlighting of occurrences and brackets.
 */
public class AspmHighlighting implements org.eclipse.jface.viewers.ISelectionProvider, org.eclipse.jface.viewers.ISelectionChangedListener {
	
	private final static ASPM.resource.aspm.ui.AspmPositionHelper positionHelper = new ASPM.resource.aspm.ui.AspmPositionHelper();
	
	private java.util.List<org.eclipse.jface.viewers.ISelectionChangedListener> selectionChangedListeners = new java.util.ArrayList<org.eclipse.jface.viewers.ISelectionChangedListener>();
	private org.eclipse.jface.viewers.ISelection selection = null;
	private boolean isHighlightBrackets = true;
	private ASPM.resource.aspm.ui.AspmTokenScanner scanner;
	private ASPM.resource.aspm.ui.AspmColorManager colorManager;
	private org.eclipse.swt.graphics.Color bracketColor;
	private org.eclipse.swt.graphics.Color black;
	private org.eclipse.swt.custom.StyledText textWidget;
	private org.eclipse.jface.preference.IPreferenceStore preferenceStore;
	private ASPM.resource.aspm.ui.AspmEditor editor;
	private org.eclipse.jface.text.source.projection.ProjectionViewer projectionViewer;
	private ASPM.resource.aspm.ui.AspmOccurrence occurrence;
	private ASPM.resource.aspm.ui.AspmBracketSet bracketSet;
	private org.eclipse.swt.widgets.Display display;
	
	/**
	 * A key and mouse listener for the highlighting. It removes the highlighting
	 * before documents change. No highlighting is set after document changes to
	 * increase the performance. Occurrences are not searched if the caret is still in
	 * the same token to increase the performance.
	 */
	private final class UpdateHighlightingListener implements org.eclipse.swt.events.KeyListener, org.eclipse.swt.events.VerifyListener, org.eclipse.swt.events.MouseListener, ASPM.resource.aspm.IAspmBackgroundParsingListener {
		
		private boolean changed = false;
		private int caret = -1;
		
		public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
		}
		
		public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
			if (changed) {
				changed = false;
				return;
			}
			refreshHighlighting();
		}
		
		private void refreshHighlighting() {
			if (textWidget.isDisposed()) {
				return;
			}
			int textCaret = textWidget.getCaretOffset();
			if (textCaret < 0 || textCaret > textWidget.getCharCount()) {
				return;
			}
			if (textCaret != caret) {
				caret = textCaret;
				removeHighlighting();
				setHighlighting();
				setEObjectSelection();
			}
		}
		
		public void verifyText(org.eclipse.swt.events.VerifyEvent e) {
			occurrence.resetTokenRegion();
			removeHighlighting();
			changed = true;
		}
		
		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
		}
		
		public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
		}
		
		// 1-left click, 2-middle click,
		public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
			// 3-right click
			if (e.button != 1) {
				return;
			}
			refreshHighlighting();
		}
		
		public void parsingCompleted(org.eclipse.emf.ecore.resource.Resource resource) {
			display.asyncExec(new Runnable() {
				
				public void run() {
					refreshHighlighting();
				}
			});
		}
	}
	
	/**
	 * Creates the highlighting manager class.
	 * 
	 * @param textResource the text resource to be provided to other classes
	 * @param sourceviewer the source viewer converts offset between master and slave
	 * documents
	 * @param colorManager the color manager provides highlighting colors
	 * @param editor
	 */
	public AspmHighlighting(ASPM.resource.aspm.IAspmTextResource textResource, org.eclipse.jface.text.source.projection.ProjectionViewer sourceviewer, ASPM.resource.aspm.ui.AspmColorManager colorManager, ASPM.resource.aspm.ui.AspmEditor editor) {
		this.display = org.eclipse.swt.widgets.Display.getCurrent();
		sourceviewer.getSelectionProvider();
		preferenceStore = ASPM.resource.aspm.ui.AspmUIPlugin.getDefault().getPreferenceStore();
		this.editor = editor;
		textWidget = sourceviewer.getTextWidget();
		projectionViewer = sourceviewer;
		scanner = new ASPM.resource.aspm.ui.AspmTokenScanner(textResource, colorManager);
		occurrence = new ASPM.resource.aspm.ui.AspmOccurrence(textResource, sourceviewer, scanner);
		bracketSet = new ASPM.resource.aspm.ui.AspmBracketSet(editor, sourceviewer);
		this.colorManager = colorManager;
		isHighlightBrackets = preferenceStore.getBoolean(ASPM.resource.aspm.ui.AspmPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		bracketColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, ASPM.resource.aspm.ui.AspmPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new org.eclipse.swt.graphics.RGB(0, 0, 0));
		
		addListeners(editor);
	}
	
	private void addListeners(ASPM.resource.aspm.ui.AspmEditor editor) {
		UpdateHighlightingListener hl = new UpdateHighlightingListener();
		textWidget.addKeyListener(hl);
		textWidget.addVerifyListener(hl);
		textWidget.addMouseListener(hl);
		editor.addBackgroundParsingListener(hl);
	}
	
	private void setHighlighting() {
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		if (isHighlightBrackets) {
			bracketSet.matchingBrackets();
		}
		occurrence.handleOccurrenceHighlighting(bracketSet);
		setBracketHighlighting(document);
	}
	
	private void setBracketHighlighting(org.eclipse.jface.text.IDocument document) {
		org.eclipse.swt.custom.StyleRange styleRange = null;
		org.eclipse.jface.text.Position[] positions = positionHelper.getPositions(document, ASPM.resource.aspm.ui.AspmPositionCategory.BRACKET.toString());
		
		for (org.eclipse.jface.text.Position position : positions) {
			org.eclipse.jface.text.Position tmpPosition = convertToWidgetPosition(position);
			if (tmpPosition != null) {
				styleRange = getStyleRangeAtPosition(tmpPosition);
				styleRange.borderStyle = org.eclipse.swt.SWT.BORDER_SOLID;
				styleRange.borderColor = bracketColor;
				if (styleRange.foreground == null) {
					styleRange.foreground = black;
				}
				textWidget.setStyleRange(styleRange);
			}
		}
	}
	
	private void removeHighlighting() {
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		// remove highlighted matching brackets
		removeHighlightingCategory(document, ASPM.resource.aspm.ui.AspmPositionCategory.BRACKET.toString());
	}
	
	private void removeHighlightingCategory(org.eclipse.jface.text.IDocument document, String category) {
		org.eclipse.jface.text.Position[] positions = positionHelper.getPositions(document, category);
		if (category.equals(ASPM.resource.aspm.ui.AspmPositionCategory.BRACKET.toString())) {
			org.eclipse.swt.custom.StyleRange styleRange;
			for (org.eclipse.jface.text.Position position : positions) {
				org.eclipse.jface.text.Position tmpPosition = convertToWidgetPosition(position);
				if (tmpPosition != null) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = org.eclipse.swt.SWT.NONE;
					styleRange.borderColor = null;
					styleRange.background = null;
					textWidget.setStyleRange(styleRange);
				}
			}
		}
		positionHelper.removePositions(document, category);
	}
	
	public void setEObjectSelection() {
		display.asyncExec(new Runnable() {
			public void run() {
				org.eclipse.emf.ecore.EObject selectedEObject = occurrence.getEObjectAtCurrentPosition();
				if (selectedEObject != null) {
					setSelection(new ASPM.resource.aspm.ui.AspmEObjectSelection(selectedEObject, false));
				}
			}
		});
	}
	
	/**
	 * Resets the changed values after setting the preference pages.
	 */
	public void resetValues() {
		isHighlightBrackets = preferenceStore.getBoolean(ASPM.resource.aspm.ui.AspmPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		bracketColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, ASPM.resource.aspm.ui.AspmPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		bracketSet.resetBrackets();
	}
	
	private org.eclipse.jface.text.Position convertToWidgetPosition(org.eclipse.jface.text.Position position) {
		if (position == null) {
			return null;
		}
		int startOffset = projectionViewer.modelOffset2WidgetOffset(position.offset);
		int endOffset = projectionViewer.modelOffset2WidgetOffset(position.offset + position.length);
		if (endOffset - startOffset != position.length || startOffset == -1 || textWidget.getCharCount() < endOffset) {
			return null;
		}
		return new org.eclipse.jface.text.Position(startOffset, endOffset - startOffset);
	}
	
	private org.eclipse.swt.custom.StyleRange getStyleRangeAtPosition(org.eclipse.jface.text.Position position) {
		org.eclipse.swt.custom.StyleRange styleRange = null;
		try {
			styleRange = textWidget.getStyleRangeAtOffset(position.offset);
		} catch (IllegalArgumentException iae) {
		}
		if (styleRange == null) {
			styleRange = new org.eclipse.swt.custom.StyleRange(position.offset, position.length, black, null);
		} else {
			styleRange.length = position.length;
		}
		return styleRange;
	}
	
	public void addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}
	
	public void removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}
	
	public void setSelection(org.eclipse.jface.viewers.ISelection selection) {
		this.selection = selection;
		for (org.eclipse.jface.viewers.ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new org.eclipse.jface.viewers.SelectionChangedEvent(this, selection));
		}
	}
	
	public org.eclipse.jface.viewers.ISelection getSelection() {
		return selection;
	}
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		if (event.getSelection() instanceof org.eclipse.jface.viewers.TreeSelection) {
			handleContentOutlineSelection(event.getSelection());
		}
	}
	
	private void handleContentOutlineSelection(org.eclipse.jface.viewers.ISelection selection) {
		if (!selection.isEmpty()) {
			editor.setSelection(selection);
		}
	}
	
}
