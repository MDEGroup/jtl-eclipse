/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public class JtlUIMetaInformation extends JTL.resource.jtl.mopp.JtlMetaInformation {
	
	public JTL.resource.jtl.IJtlHoverTextProvider getHoverTextProvider() {
		return new JTL.resource.jtl.ui.JtlHoverTextProvider();
	}
	
	public JTL.resource.jtl.ui.JtlImageProvider getImageProvider() {
		return JTL.resource.jtl.ui.JtlImageProvider.INSTANCE;
	}
	
	public JTL.resource.jtl.ui.JtlColorManager createColorManager() {
		return new JTL.resource.jtl.ui.JtlColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(JTL.resource.jtl.IJtlTextResource,
	 * JTL.resource.jtl.ui.JtlColorManager) instead.
	 */
	public JTL.resource.jtl.ui.JtlTokenScanner createTokenScanner(JTL.resource.jtl.ui.JtlColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public JTL.resource.jtl.ui.JtlTokenScanner createTokenScanner(JTL.resource.jtl.IJtlTextResource resource, JTL.resource.jtl.ui.JtlColorManager colorManager) {
		return new JTL.resource.jtl.ui.JtlTokenScanner(resource, colorManager);
	}
	
	public JTL.resource.jtl.ui.JtlCodeCompletionHelper createCodeCompletionHelper() {
		return new JTL.resource.jtl.ui.JtlCodeCompletionHelper();
	}
	
}
