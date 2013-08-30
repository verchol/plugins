package com.codenvy.ide.extension.scaffolding;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.action.ActionManager;
import com.codenvy.ide.api.ui.action.DefaultActionGroup;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Scaffolding Extension", version = "1.0.0")
public class ScaffoldingExtension {

    @Inject
    public ScaffoldingExtension(ActionManager actionManager,
                         ScaffoldingExtensionLocalizationConstant localizationConstants) {
        // register a new action
        // actionManager.registerAction(localizationConstants.createGistActionlId(), createVagrantfileAction);
        // DefaultActionGroup saveActionGroup = (DefaultActionGroup)actionManager.getAction("saveGroup");
        // saveActionGroup.add(createVagrantfileAction);
    }
}
