package com.codenvy.ide.extension.apachelogger;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Client resources.
 */
public interface ApacheLoggerExtensionResources extends ClientBundle {
    public interface GistCSS extends CssResource {
        String textFont();
    }

    //@Source({"Gist.css", "com/codenvy/ide/api/ui/style.css"})
    //GistCSS gistCSS();

    @Source("com/codenvy/ide/extension/apachelogger/images/codenvy.png")
    ImageResource icon();
}
