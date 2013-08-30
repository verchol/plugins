package com.codenvy.ide.extension.apachelogger;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.action.ActionManager;
import com.codenvy.ide.api.ui.action.DefaultActionGroup;
import com.codenvy.ide.extension.demo.actions.ConfigureLoggerAction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Apache Logger Extension", version = "1.0.0")
public class ApacheLoggerExtension {

    @Inject
    public ApacheLoggerExtension(ActionManager actionManager,
                         ApacheLoggerExtensionLocalizationConstant localizationConstants,
                         ConfigureLoggerAction configureLoggerAction) {
        // Register a new action
        actionManager.registerAction(localizationConstants.configureLoggerActionId(), createLoggerAction);
        // Get a reference of the Project Menu
        DefaultActionGroup projectGroup = (DefaultActionGroup)actionManager.getAction(IdeActions.GROUP_PROJECT);
        
        // Create a new submenu called Apache Logger
        DefaultActionGroup apacheLoggerActionGroup = new DefaultActionGroup("Apache Logger", true, actionManager);
        actionManager.registerAction("Apache Logger", apacheLoggerActionGroup);
        // Add Apache Logger to the Project Menu
        projectGroup.add(apacheLoggerActionGroup);
        
        // Add the Configure Logger action to the Apache Logger submenu
        apacheLoggerActionGroup.add(createLoggerAction);
    }
}
