/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public class AspmmUIMetaInformation extends ASPMM.resource.aspmm.mopp.AspmmMetaInformation {
	
	public ASPMM.resource.aspmm.IAspmmHoverTextProvider getHoverTextProvider() {
		return new ASPMM.resource.aspmm.ui.AspmmHoverTextProvider();
	}
	
	public ASPMM.resource.aspmm.ui.AspmmImageProvider getImageProvider() {
		return ASPMM.resource.aspmm.ui.AspmmImageProvider.INSTANCE;
	}
	
	public ASPMM.resource.aspmm.ui.AspmmColorManager createColorManager() {
		return new ASPMM.resource.aspmm.ui.AspmmColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(ASPMM.resource.aspmm.IAspmmTextResource,
	 * ASPMM.resource.aspmm.ui.AspmmColorManager) instead.
	 */
	public ASPMM.resource.aspmm.ui.AspmmTokenScanner createTokenScanner(ASPMM.resource.aspmm.ui.AspmmColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public ASPMM.resource.aspmm.ui.AspmmTokenScanner createTokenScanner(ASPMM.resource.aspmm.IAspmmTextResource resource, ASPMM.resource.aspmm.ui.AspmmColorManager colorManager) {
		return new ASPMM.resource.aspmm.ui.AspmmTokenScanner(resource, colorManager);
	}
	
	public ASPMM.resource.aspmm.ui.AspmmCodeCompletionHelper createCodeCompletionHelper() {
		return new ASPMM.resource.aspmm.ui.AspmmCodeCompletionHelper();
	}
	
}
