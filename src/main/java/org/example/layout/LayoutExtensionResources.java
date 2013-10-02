package org.example.layout;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Client resources.
 */
public interface LayoutExtensionResources extends ClientBundle {
    public interface LayoutCSS extends CssResource {
        String textFont();
    }

//    @Source({"styles.css", "com/codenvy/ide/api/ui/styles.css"})
//    LayoutCSS styles();

    @Source("org/example/layout/images/codenvy.png")
    ImageResource icon();
    
    @Source("org/example/layout/images/message.png")
    ImageResource message();
    
}
