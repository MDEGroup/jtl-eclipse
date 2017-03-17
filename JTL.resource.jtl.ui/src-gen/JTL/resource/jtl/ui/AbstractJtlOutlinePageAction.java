/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package JTL.resource.jtl.ui;

public abstract class AbstractJtlOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer;
	
	public AbstractJtlOutlinePageAction(JTL.resource.jtl.ui.JtlOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = JTL.resource.jtl.ui.JtlImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = JTL.resource.jtl.ui.JtlUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			JTL.resource.jtl.ui.JtlUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public JTL.resource.jtl.ui.JtlOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public JTL.resource.jtl.ui.JtlOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (JTL.resource.jtl.ui.JtlOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
