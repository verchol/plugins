package org.example.client.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import org.example.layout.parts.NavigationPart;
import org.example.layout.parts.NavigationPartPresenter;
import org.example.layout.parts.NavigationPartView;
import org.example.layout.parts.NavigationPartViewImpl;

@ExtensionGinModule
public class LayoutGinModule extends AbstractGinModule {
    /** {@inheritDoc} */
    @Override
    protected void configure() {
    	bind(NavigationPart.class).to(NavigationPartPresenter.class).in(Singleton.class);        
    	bind(NavigationPartView.class).to(NavigationPartViewImpl.class).in(Singleton.class);
    }
}
