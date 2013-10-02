package org.example.layout;

import com.google.gwt.i18n.client.Messages;

/**
 * Interface to represent the constants contained in resource bundle: 'LayoutExtensionLocalizationConstant.properties'.
 */
public interface LayoutExtensionLocalizationConstant extends Messages {
    /* Messages */
    @Key("messages.extensionRunning")
    String extensionRunning();
    
    @Key("notification.triggerNotificationId")
    String triggerNotificationId();    
        
    @Key("notification.triggerNotificationText")
    String triggerNotificationText();
    
    @Key("notification.triggerNotificationDescription")
    String triggerNotificationDescription();
    
    @Key("notification.triggerNotificationMessage")
    String triggerNotificationMessage();

    @Key("notification.triggerNotificationConsoleMessage")
    String triggerNotificationConsoleMessage();
    
}
