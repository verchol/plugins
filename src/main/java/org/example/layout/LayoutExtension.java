package org.example.layout;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.api.ui.workspace.PartStackType;
import com.codenvy.ide.api.parts.ConsolePart;
import com.codenvy.ide.api.ui.action.IdeActions;
import com.codenvy.ide.api.ui.action.ActionManager;
import com.codenvy.ide.api.ui.action.DefaultActionGroup;
import org.example.layout.actions.TriggerNotificationAction;
import org.example.layout.parts.NavigationPart;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.gwt.user.client.Timer;

// import org.example.layout.parts.NavigationPartPresenter;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Layout Extension", version = "1.0.0")
public class LayoutExtension {

   private LayoutExtensionLocalizationConstant localizationConstants;
   private WorkspaceAgent workspace;
   private ConsolePart console;
   private NavigationPart nav;
   
	@Inject
	public LayoutExtension(LayoutExtensionLocalizationConstant localizationConstants,
			WorkspaceAgent workspace, ConsolePart console, 
      NavigationPart nav,
			ActionManager actionManager, TriggerNotificationAction triggerNotificationAction) {

	   this.localizationConstants = localizationConstants;
	   this.workspace = workspace;
	   this.console = console;
     this.nav = nav;

	   // Add panels around the entire workspace. 
	   addWorkspacePanels();	   
	   
	   // Register action for triggering an SDK notification
       actionManager.registerAction(localizationConstants.triggerNotificationText(), triggerNotificationAction);

       // Add action to the toolbar
       DefaultActionGroup toolbarActionGroup = (DefaultActionGroup) actionManager.getAction(IdeActions.GROUP_MAIN_TOOLBAR);
       toolbarActionGroup.add(triggerNotificationAction);	   
	   
	   // Add action to the default context menu       
       DefaultActionGroup contextActionGroup = (DefaultActionGroup) actionManager.getAction(IdeActions.GROUP_MAIN_CONTEXT_MENU);
       contextActionGroup.add(triggerNotificationAction);	   
	   
	   // Show a simple message in the console
	   console.print(localizationConstants.extensionRunning());
	}
	
	private void addWorkspacePanels() {
		// Add a left navigation pane
		workspace.openPart(nav, PartStackType.NAVIGATION);
		// Add an editing pane
		workspace.openPart(nav, PartStackType.EDITING);
		// Add a right pane
		workspace.openPart(nav, PartStackType.TOOLING);
		// Add a bottom pane
		workspace.openPart(nav, PartStackType.INFORMATION);
	}

}
