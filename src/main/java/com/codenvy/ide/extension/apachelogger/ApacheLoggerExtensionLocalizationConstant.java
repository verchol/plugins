package com.codenvy.ide.extension.apachelogger;

import com.google.gwt.i18n.client.Messages;

/**
 * Interface to represent the constants contained in resource bundle: 'ApacheLoggerExtensionLocalizationConstant.properties'.
 */
public interface ApacheLoggerExtensionLocalizationConstant extends Messages {
    /* Messages */
    @Key("messages.loaded")
    String extensionRunning();

    /* Actions */
    @Key("control.configureLogger.id")
    String configureLoggerActionId();

    @Key("control.configureLogger.text")
    String configureLoggerActionText();

    @Key("control.configureLogger.description")
    String configureLoggerActionDescription();
}

