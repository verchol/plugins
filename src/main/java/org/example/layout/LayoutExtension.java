package org.example.layout;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.workspace.WorkspaceAgent;
import com.codenvy.ide.api.ui.workspace.PartStackType;
import com.codenvy.ide.api.parts.ConsolePart;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.gwt.user.client.Timer;
import com.codenvy.ide.api.notification.Notification;
import com.codenvy.ide.api.notification.NotificationManager;

// import org.example.layout.parts.NavigationPartPresenter;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Layout Extension", version = "1.0.0")
public class LayoutExtension {

   private NotificationManager notificationManager;
   private LayoutExtensionLocalizationConstant localizationConstants;
   
	@Inject
	public LayoutExtension(
			LayoutExtensionLocalizationConstant localizationConstants,
			WorkspaceAgent workspace, ConsolePart console, NotificationManager notificationManager) {
			//NavigationPartPresenter navigation) {

	   this.localizationConstants = localizationConstants;
	   this.notificationManager = notificationManager;
	    
		// Add a left navigation pane
		workspace.openPart(console, PartStackType.NAVIGATION);
		// Add an editing pane
		workspace.openPart(console, PartStackType.EDITING);
		// Add a right pane
		workspace.openPart(console, PartStackType.TOOLING);
		// Add a bottom pane
		workspace.openPart(console, PartStackType.INFORMATION);

		// Show a simple message in the console
		console.print(localizationConstants.extensionRunning());
      
      Timer t = new Timer() {
          @Override
          public void run() {
              displayNotification();
          }
      };
      t.scheduleRepeating(5000);
	}
	
	public void displayNotification() {
        Notification notification = new Notification(localizationConstants.extensionFinishedLoading(), Notification.Type.INFO);
        notificationManager.showNotification(notification);
	}
}
