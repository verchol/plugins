package com.codenvy.ide.extension.demo.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.codenvy.ide.extension.demo.createGist.CreateGistView;
import com.codenvy.ide.extension.demo.createGist.CreateGistViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

@ExtensionGinModule
public class GistGinModule extends AbstractGinModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
        bind(CreateGistView.class).to(CreateGistViewImpl.class).in(Singleton.class);
    }
}