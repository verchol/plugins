package org.example.layout;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.api.ui.workspace.PartStackType;
import com.codenvy.ide.api.parts.ConsolePart;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.example.layout.parts.NavigationPartPresenter;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Layout Extension", version = "1.0.0")
public class LayoutExtension {

	@Inject
	public LayoutExtension(
			LayoutExtensionLocalizationConstant localizationConstants,
			WorkspaceAgent workspace, ConsolePart console,
			NavigationPartPresenter navigation) {

		// Add a left navigation pane
		workspace.openPart(navigation, PartStackType.NAVIGATION);
		// Add an editing pane
		workspace.openPart(console, PartStackType.EDITING);
		// Add a right pane
		workspace.openPart(console, PartStackType.TOOLING);
		// Add a bottom pane
		workspace.openPart(console, PartStackType.INFORMATION);

		// Show a simple message in the console
		console.print(localizationConstants.extensionRunning());
	}
}
