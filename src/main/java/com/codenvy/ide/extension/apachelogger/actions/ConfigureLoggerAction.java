package com.codenvy.ide.extension.apachelogger.actions;

import com.codenvy.ide.api.resources.ResourceProvider;
import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionLocalizationConstant;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionResources;
import com.codenvy.ide.extension.apachelogger.configureLogger.ConfigureLoggerPresenter;
import com.codenvy.ide.resources.model.Project;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.codenvy.ide.api.parts.ConsolePart;


/**
 * Action for configuring Apache Logger
 */
@Singleton
public class ConfigureLoggerAction extends Action {

    private ConfigureLoggerPresenter configureLoggerPresenter;
    private ResourceProvider resourceProvider;
    private ConsolePart console;

    @Inject
    public ConfigureLoggerAction(ConfigureLoggerPresenter configureLoggerPresenter,
    						ApacheLoggerExtensionResources resources,
                            ApacheLoggerExtensionLocalizationConstant localizationConstants,
                            ResourceProvider resourceProvider,
                            ConsolePart console) {
        super(localizationConstants.configureLoggerActionText(), localizationConstants.configureLoggerActionDescription(), resources.icon());
        this.configureLoggerPresenter = configureLoggerPresenter;
        this.resourceProvider = resourceProvider;
        this.console = console;
        
        Project activeProject = resourceProvider.getActiveProject();
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
    	Project activeProject = resourceProvider.getActiveProject();
    	if (activeProject != null) {
            configureLoggerPresenter.showDialog();
    	} else {
    		console.print("No project open.");
    	}
    	
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
