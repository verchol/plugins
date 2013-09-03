package com.codenvy.ide.extension.scaffolding.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

@ExtensionGinModule
public class ScaffoldingGinModule extends AbstractGinModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
        // bind(CreateVagrantfileView.class).to(CreateVagrantfileViewImpl.class).in(Singleton.class);
    }
}