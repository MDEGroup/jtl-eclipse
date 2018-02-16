/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPT.resource.aspt.ui;

public abstract class AbstractAsptOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer treeViewer;
	
	public AbstractAsptOutlinePageAction(ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = ASPT.resource.aspt.ui.AsptImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = ASPT.resource.aspt.ui.AsptUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			ASPT.resource.aspt.ui.AsptUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public ASPT.resource.aspt.ui.AsptOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public ASPT.resource.aspt.ui.AsptOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (ASPT.resource.aspt.ui.AsptOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
