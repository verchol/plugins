package org.example.layout;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.api.ui.workspace.PartStackType;
import com.codenvy.ide.api.parts.ConsolePart;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.example.layout.parts.NavigationPart;

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
                         ConsolePart console,
                         NavigationPart navigation) {
        
    	// Add the console to several parts of the workspace.
    	// Left pane
    	workspace.openPart(navigation,PartStackType.NAVIGATION);
    	// Editor
    	workspace.openPart(console,PartStackType.EDITING);
    	// Right pane
    	workspace.openPart(console,PartStackType.TOOLING);
    	// Bottom pane
    	workspace.openPart(console,PartStackType.INFORMATION);
    	
    	
       // Show a simple message in the console
       console.print(localizationConstants.extensionRunning());        
    }
}
