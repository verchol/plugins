package org.example.scaffolding;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Client resources.
 */
public interface ScaffoldingExtensionResources extends ClientBundle {
    public interface ScaffoldingCSS extends CssResource {
        String textFont();
    }

    @Source({"styles.css", "com/codenvy/ide/api/ui/styles.css"})
    ScaffoldingCSS styles();

    @Source("org/example/images/codenvy.png")
    ImageResource icon();
}
