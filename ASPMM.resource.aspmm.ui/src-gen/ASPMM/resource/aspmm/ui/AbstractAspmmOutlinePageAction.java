/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.ui;

public abstract class AbstractAspmmOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer;
	
	public AbstractAspmmOutlinePageAction(ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = ASPMM.resource.aspmm.ui.AspmmImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = ASPMM.resource.aspmm.ui.AspmmUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			ASPMM.resource.aspmm.ui.AspmmUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (ASPMM.resource.aspmm.ui.AspmmOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
