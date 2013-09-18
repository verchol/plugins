package org.example.scaffolding;

import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.parts.ConsolePart;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Extension used to demonstrate the Codenvy SDK features.
 */
@Singleton
@Extension(title = "Scaffolding Extension", version = "1.0.0")
public class ScaffoldingExtension {

    @Inject
    public ScaffoldingExtension(
                         ScaffoldingExtensionLocalizationConstant localizationConstants,
                         ConsolePart console) {
        
        // Show a simple message in the console
        console.print(localizationConstants.extensionRunning());        
    }
}
