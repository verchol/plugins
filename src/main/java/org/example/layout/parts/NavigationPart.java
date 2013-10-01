package org.example.layout.parts;

import com.codenvy.ide.api.extension.SDK;
import com.codenvy.ide.api.ui.workspace.PartPresenter;

/**
 * Provides navigation panel.
 */
@SDK(title = "org.example.Navigation")
public interface NavigationPart extends PartPresenter {
    /**
     * Print message on Navigation.
     *
     * @param message
     */
    public void print(String message);
}