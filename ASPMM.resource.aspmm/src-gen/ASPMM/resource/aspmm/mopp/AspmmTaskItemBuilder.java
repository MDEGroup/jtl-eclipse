/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPMM.resource.aspmm.mopp;

/**
 * The AspmmTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class AspmmTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new ASPMM.resource.aspmm.mopp.AspmmMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<ASPMM.resource.aspmm.mopp.AspmmTaskItem> taskItems = new java.util.ArrayList<ASPMM.resource.aspmm.mopp.AspmmTaskItem>();
		ASPMM.resource.aspmm.mopp.AspmmTaskItemDetector taskItemDetector = new ASPMM.resource.aspmm.mopp.AspmmTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = ASPMM.resource.aspmm.util.AspmmStreamUtil.getContent(inputStream);
			ASPMM.resource.aspmm.IAspmmTextScanner lexer = new ASPMM.resource.aspmm.mopp.AspmmMetaInformation().createLexer();
			lexer.setText(content);
			
			ASPMM.resource.aspmm.IAspmmTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			ASPMM.resource.aspmm.mopp.AspmmPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			ASPMM.resource.aspmm.mopp.AspmmPlugin.logError("Exception while searching for task items", e);
		}
		
		for (ASPMM.resource.aspmm.mopp.AspmmTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new ASPMM.resource.aspmm.mopp.AspmmMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
