package org.example.demo;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.ui.action.ActionManager;
import com.codenvy.ide.api.ui.action.DefaultActionGroup;
import org.example.demo.actions.CreateGistAction;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "GitHub Gist extension", version = "1.0.0")
public class GistExtension {

    @Inject
    public GistExtension(ActionManager actionManager,
                         GistExtensionLocalizationConstant localizationConstants,
                         CreateGistAction createGistAction) {
        // register a new action
        actionManager.registerAction(localizationConstants.createGistActionlId(), createGistAction);
        DefaultActionGroup saveActionGroup = (DefaultActionGroup)actionManager.getAction("saveGroup");
        saveActionGroup.add(createGistAction);
    }
}
