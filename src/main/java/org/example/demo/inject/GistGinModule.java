package org.example.demo.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import org.example.demo.createGist.CreateGistView;
import org.example.demo.createGist.CreateGistViewImpl;
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
