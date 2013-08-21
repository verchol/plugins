package com.codenvy.ide.extension.vagrant;

import com.google.gwt.i18n.client.Messages;

/**
 * Interface to represent the constants contained in resource bundle: 'VagrantExtensionLocalizationConstant.properties'.
 */
public interface VagrantExtensionLocalizationConstant extends Messages {
    /* Buttons */
    @Key("button.cancel")
    String buttonCancel();

    @Key("button.create")
    String buttonCreate();

    /* Actions */
    @Key("control.createGist.id")
    String createGistActionlId();

    @Key("control.createGist.text")
    String createGistActionText();

    @Key("control.createGist.description")
    String createGistActionDescription();

    /* Messages */
    @Key("messages.openFileToCreateGist")
    String openFileToCreateGist();

    @Key("messages.projectIsNotOpened")
    String projectIsNotOpened();

    @Key("messages.createGistError")
    String createGistError();

    @Key("messages.detectGistIdError")
    String detectGistIdError();

    /* CreateVagrantfileView */
    @Key("createGist.title")
    String createViewTitle();

    @Key("createGist.publicFieldTitle")
    String publicFieldTitle();

    @Key("createGist.snippetFieldTitle")
    String snippetFieldTitle();
}
