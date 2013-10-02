package org.example.layout;

import com.google.gwt.i18n.client.Messages;

/**
 * Interface to represent the constants contained in resource bundle: 'LayoutExtensionLocalizationConstant.properties'.
 */
public interface LayoutExtensionLocalizationConstant extends Messages {
    /* Messages */
    @Key("messages.extensionRunning")
    String extensionRunning();
    
    @Key("messages.extensionFinishedLoading")
    String extensionFinishedLoading();
    
    @Key("messages.triggerNotificationText")
    String triggerNotificationText();    
    
    @Key("messages.triggerNotificationDescription")
    String triggerNotificationDescription();    
}
