package com.codenvy.ide.extension.apachelogger.actions;

import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionLocalizationConstant;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionResources;
import com.codenvy.ide.extension.apachelogger.configureLogger.ConfigureLoggerPresenter;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Action for configuring Apache Logger
 */
@Singleton
public class ConfigureLoggerAction extends Action {

    private ConfigureLoggerPresenter configureLoggerPresenter;

    @Inject
    public ConfigureLoggerAction(ApacheLoggerExtensionResources resources,
                            ConfigureLoggerPresenter configureLoggerPresenter,
                            ApacheLoggerExtensionLocalizationConstant localizationConstants) {
        super(localizationConstants.configureLoggerActionText(), localizationConstants.configureLoggerActionDescription(), resources.icon());
        this.configureLoggerPresenter = configureLoggerPresenter;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        configureLoggerPresenter.showDialog();
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
