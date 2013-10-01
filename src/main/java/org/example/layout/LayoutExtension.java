package org.example.layout;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.api.ui.workspace.PartStackType;
import com.codenvy.ide.api.parts.ConsolePart;
import com.codenvy.ide.part.console.ConsolePartPresenter;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Layout Extension", version = "1.0.0")
public class LayoutExtension {

    @Inject
    public LayoutExtension(
                         LayoutExtensionLocalizationConstant localizationConstants,
                         WorkspaceAgent workspace,
                         ConsolePartPresenter consolePart, 
                         ConsolePart console) {
        
    	// Add the console to several parts of the workspace.
    	// Left pane
    	WorkspaceAgent.openPart(cpp,PartStackType.NAVIGATION);
    	// Editor
    	WorkspaceAgent.openPart(cpp,PartStackType.EDITING);
    	// Right pane
    	WorkspaceAgent.openPart(cpp,PartStackType.TOOLING);
    	// Bottom pane
    	WorkspaceAgent.openPart(cpp,PartStackType.INFORMATION);
    	
    	
        // Show a simple message in the console
        console.print(localizationConstants.extensionRunning());        
    }
}
