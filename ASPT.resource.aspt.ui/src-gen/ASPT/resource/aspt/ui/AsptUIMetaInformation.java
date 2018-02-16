/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public class AsptUIMetaInformation extends ASPT.resource.aspt.mopp.AsptMetaInformation {
	
	public ASPT.resource.aspt.IAsptHoverTextProvider getHoverTextProvider() {
		return new ASPT.resource.aspt.ui.AsptHoverTextProvider();
	}
	
	public ASPT.resource.aspt.ui.AsptImageProvider getImageProvider() {
		return ASPT.resource.aspt.ui.AsptImageProvider.INSTANCE;
	}
	
	public ASPT.resource.aspt.ui.AsptColorManager createColorManager() {
		return new ASPT.resource.aspt.ui.AsptColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(ASPT.resource.aspt.IAsptTextResource,
	 * ASPT.resource.aspt.ui.AsptColorManager) instead.
	 */
	public ASPT.resource.aspt.ui.AsptTokenScanner createTokenScanner(ASPT.resource.aspt.ui.AsptColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public ASPT.resource.aspt.ui.AsptTokenScanner createTokenScanner(ASPT.resource.aspt.IAsptTextResource resource, ASPT.resource.aspt.ui.AsptColorManager colorManager) {
		return new ASPT.resource.aspt.ui.AsptTokenScanner(resource, colorManager);
	}
	
	public ASPT.resource.aspt.ui.AsptCodeCompletionHelper createCodeCompletionHelper() {
		return new ASPT.resource.aspt.ui.AsptCodeCompletionHelper();
	}
	
}
