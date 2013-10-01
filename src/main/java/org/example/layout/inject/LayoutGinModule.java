package org.example.inject;

import org.example.layout.parts.NavigationPartView;
import org.example.layout.parts.NavigationPartViewImpl;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

@ExtensionGinModule
public class LayoutGinModule extends AbstractGinModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
    	bind(NavigationPartView.class).to(NavigationPartViewImpl.class).in(Singleton.class);
    }
}
