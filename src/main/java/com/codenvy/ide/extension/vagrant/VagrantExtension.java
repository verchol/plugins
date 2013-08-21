package com.codenvy.ide.extension.vagrant;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.action.ActionManager;
import com.codenvy.ide.api.ui.action.DefaultActionGroup;
import com.codenvy.ide.extension.vagrant.actions.CreateVagrantfileAction;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "GitHub Gist extension", version = "1.0.0")
public class VagrantExtension {

    @Inject
    public VagrantExtension(ActionManager actionManager,
                         VagrantExtensionLocalizationConstant localizationConstants,
                         CreateVagrantfileAction createVagrantfileAction) {
        // register a new action
        actionManager.registerAction(localizationConstants.createGistActionlId(), createVagrantfileAction);
        DefaultActionGroup saveActionGroup = (DefaultActionGroup)actionManager.getAction("saveGroup");
        saveActionGroup.add(createVagrantfileAction);
    }
}
