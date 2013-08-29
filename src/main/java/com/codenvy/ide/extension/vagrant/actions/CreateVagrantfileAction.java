package com.codenvy.ide.extension.vagrant.actions;

import com.codenvy.ide.api.parts.ConsolePart;
import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.extension.vagrant.VagrantExtensionLocalizationConstant;
import com.codenvy.ide.extension.vagrant.VagrantExtensionResources;
import com.codenvy.ide.extension.vagrant.createVagrantfile.CreateVagrantfilePresenter;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Action for creating Gist on GitHub.
 */
@Singleton
public class CreateVagrantfileAction extends Action {

    private CreateVagrantfilePresenter createVagrantfilePresenter;
    private ConsolePart    console;

    @Inject
    public CreateVagrantfileAction(VagrantExtensionResources resources,
                            CreateVagrantfilePresenter createVagrantfilePresenter,
                            VagrantExtensionLocalizationConstant localizationConstants,
                            ConsolePart console) {
        super(localizationConstants.createGistActionText(), localizationConstants.createGistActionDescription(), resources.github());
        this.createVagrantfilePresenter = createVagrantfilePresenter;
        this.console = console;
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        // createVagrantfilePresenter.showDialog();
        com.google.gwt.user.client.Window.alert("Hello");
        console.print("I'm actually running");
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
