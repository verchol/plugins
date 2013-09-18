package org.example.demo.actions;

import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import org.example.demo.GistExtensionLocalizationConstant;
import org.example.demo.GistExtensionResources;
import org.example.demo.createGist.CreateGistPresenter;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Action for creating Gist on GitHub.
 */
@Singleton
public class CreateGistAction extends Action {

    private CreateGistPresenter createGistPresenter;

    @Inject
    public CreateGistAction(GistExtensionResources resources,
                            CreateGistPresenter createGistPresenter,
                            GistExtensionLocalizationConstant localizationConstants) {
        super(localizationConstants.createGistActionText(), localizationConstants.createGistActionDescription(), resources.github());
        this.createGistPresenter = createGistPresenter;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        createGistPresenter.showDialog();
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
