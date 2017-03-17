/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASP.resource.asp.ui;

public class AspUIMetaInformation extends ASP.resource.asp.mopp.AspMetaInformation {
	
	public ASP.resource.asp.IAspHoverTextProvider getHoverTextProvider() {
		return new ASP.resource.asp.ui.AspHoverTextProvider();
	}
	
	public ASP.resource.asp.ui.AspImageProvider getImageProvider() {
		return ASP.resource.asp.ui.AspImageProvider.INSTANCE;
	}
	
	public ASP.resource.asp.ui.AspColorManager createColorManager() {
		return new ASP.resource.asp.ui.AspColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(ASP.resource.asp.IAspTextResource,
	 * ASP.resource.asp.ui.AspColorManager) instead.
	 */
	public ASP.resource.asp.ui.AspTokenScanner createTokenScanner(ASP.resource.asp.ui.AspColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public ASP.resource.asp.ui.AspTokenScanner createTokenScanner(ASP.resource.asp.IAspTextResource resource, ASP.resource.asp.ui.AspColorManager colorManager) {
		return new ASP.resource.asp.ui.AspTokenScanner(resource, colorManager);
	}
	
	public ASP.resource.asp.ui.AspCodeCompletionHelper createCodeCompletionHelper() {
		return new ASP.resource.asp.ui.AspCodeCompletionHelper();
	}
	
}
