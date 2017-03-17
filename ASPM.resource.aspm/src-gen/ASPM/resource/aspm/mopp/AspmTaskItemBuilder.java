/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package ASPM.resource.aspm.mopp;

/**
 * The AspmTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class AspmTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new ASPM.resource.aspm.mopp.AspmMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<ASPM.resource.aspm.mopp.AspmTaskItem> taskItems = new java.util.ArrayList<ASPM.resource.aspm.mopp.AspmTaskItem>();
		ASPM.resource.aspm.mopp.AspmTaskItemDetector taskItemDetector = new ASPM.resource.aspm.mopp.AspmTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = ASPM.resource.aspm.util.AspmStreamUtil.getContent(inputStream);
			ASPM.resource.aspm.IAspmTextScanner lexer = new ASPM.resource.aspm.mopp.AspmMetaInformation().createLexer();
			lexer.setText(content);
			
			ASPM.resource.aspm.IAspmTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			ASPM.resource.aspm.mopp.AspmPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			ASPM.resource.aspm.mopp.AspmPlugin.logError("Exception while searching for task items", e);
		}
		
		for (ASPM.resource.aspm.mopp.AspmTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new ASPM.resource.aspm.mopp.AspmMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
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
