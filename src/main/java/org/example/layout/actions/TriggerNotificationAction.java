package org.example.layout.actions;

import org.example.layout.LayoutExtensionLocalizationConstant;
import org.example.layout.LayoutExtensionResources;
import com.google.gwt.resources.client.ImageResource;
import com.codenvy.ide.api.parts.ConsolePart;
import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.api.notification.Notification;
import com.codenvy.ide.api.notification.NotificationManager;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Action for creating Gist on GitHub.
 */
@Singleton
public class TriggerNotificationAction extends Action {

	private LayoutExtensionLocalizationConstant localizationConstants;
	private NotificationManager notificationManager;
	private ConsolePart console;
	private int i;

    @Inject
    public TriggerNotificationAction(LayoutExtensionLocalizationConstant localizationConstants, 
    		NotificationManager notificationManager, LayoutExtensionResources resources, 
    		ConsolePart console) {
    	
    	super(localizationConstants.triggerNotificationText(), 
    			localizationConstants.triggerNotificationDescription(), 
    			resources.message());
    	
    	i = 0;
    	this.localizationConstants = localizationConstants;
    	this.notificationManager = notificationManager;
    	this.console = console;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
    	i++;
        displayNotification();
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        // Do nothing on update
    }
        
	private void displayNotification() {
        Notification notification = new Notification(localizationConstants.triggerNotificationMessage(), Notification.Type.INFO);
        notificationManager.showNotification(notification);
        console.print(String.format(localizationConstants.triggerNotificationConsoleMessage(), i));
	}
}