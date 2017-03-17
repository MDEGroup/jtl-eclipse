/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public class AspmUIMetaInformation extends ASPM.resource.aspm.mopp.AspmMetaInformation {
	
	public ASPM.resource.aspm.IAspmHoverTextProvider getHoverTextProvider() {
		return new ASPM.resource.aspm.ui.AspmHoverTextProvider();
	}
	
	public ASPM.resource.aspm.ui.AspmImageProvider getImageProvider() {
		return ASPM.resource.aspm.ui.AspmImageProvider.INSTANCE;
	}
	
	public ASPM.resource.aspm.ui.AspmColorManager createColorManager() {
		return new ASPM.resource.aspm.ui.AspmColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(ASPM.resource.aspm.IAspmTextResource,
	 * ASPM.resource.aspm.ui.AspmColorManager) instead.
	 */
	public ASPM.resource.aspm.ui.AspmTokenScanner createTokenScanner(ASPM.resource.aspm.ui.AspmColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public ASPM.resource.aspm.ui.AspmTokenScanner createTokenScanner(ASPM.resource.aspm.IAspmTextResource resource, ASPM.resource.aspm.ui.AspmColorManager colorManager) {
		return new ASPM.resource.aspm.ui.AspmTokenScanner(resource, colorManager);
	}
	
	public ASPM.resource.aspm.ui.AspmCodeCompletionHelper createCodeCompletionHelper() {
		return new ASPM.resource.aspm.ui.AspmCodeCompletionHelper();
	}
	
}
