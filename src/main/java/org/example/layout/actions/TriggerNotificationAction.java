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

    @Inject
    public TriggerNotificationAction(LayoutExtensionLocalizationConstant localizationConstants, 
    		NotificationManager notificationManager, LayoutExtensionResources resources ) {
    	
    	super(localizationConstants.triggerNotificationText(), 
    			localizationConstants.triggerNotificationDescription(), 
    			resources.message());
    	
    	this.localizationConstants = localizationConstants;
    	this.notificationManager = notificationManager;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        displayNotification();
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        // Do nothing on update
    }
        
	private void displayNotification() {
        Notification notification = new Notification(localizationConstants.extensionFinishedLoading(), Notification.Type.INFO);
        notificationManager.showNotification(notification);
	}    
}