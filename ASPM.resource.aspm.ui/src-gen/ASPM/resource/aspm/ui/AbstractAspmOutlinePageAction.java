/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.ui;

public abstract class AbstractAspmOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer;
	
	public AbstractAspmOutlinePageAction(ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = ASPM.resource.aspm.ui.AspmImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = ASPM.resource.aspm.ui.AspmUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			ASPM.resource.aspm.ui.AspmUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public ASPM.resource.aspm.ui.AspmOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public ASPM.resource.aspm.ui.AspmOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (ASPM.resource.aspm.ui.AspmOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
