package org.example.apachelogger.inject;

import com.codenvy.ide.api.extension.ExtensionGinModule;
import org.example.apachelogger.configureLogger.ConfigureLoggerView;
import org.example.apachelogger.configureLogger.ConfigureLoggerViewImpl;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

@ExtensionGinModule
public class ApacheLoggerGinModule extends AbstractGinModule {
      /** {@inheritDoc} */
      @Override
      protected void configure() {
    	  bind(ConfigureLoggerView.class).to(ConfigureLoggerViewImpl.class).in(Singleton.class);
      }
}
