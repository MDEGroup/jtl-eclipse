/**
 * 
 */
package jtl.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class RegisterMetamodelHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// Get the active window
		IWorkbenchWindow window = 
				HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		// Get the selected resource (file)
		Object element = ((IStructuredSelection) window
				.getSelectionService().getSelection()).getFirstElement();
		IFile file = (IFile) Platform.getAdapterManager()
				.getAdapter(element, IFile.class);
		
		// Register the metamodel
		RegisterMetamodel.registerMetamodel(file);
		
		return null;
	}

}
