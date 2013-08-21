package com.codenvy.ide.extension.vagrant.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.codenvy.ide.extension.vagrant.createVagrantfile.CreateVagrantfileView;
import com.codenvy.ide.extension.vagrant.createVagrantfile.CreateVagrantfileViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

@ExtensionGinModule
public class GistGinModule extends AbstractGinModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
        bind(CreateVagrantfileView.class).to(CreateVagrantfileViewImpl.class).in(Singleton.class);
    }
}