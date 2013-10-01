package org.example.layout.parts;

import com.codenvy.ide.api.mvp.View;
import com.codenvy.ide.api.parts.base.BaseActionDelegate;

/**
 * View of {@link NavigationPartPresenter}.
 *
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
public interface NavigationPartView extends View<NavigationPartView.ActionDelegate> {
    public interface ActionDelegate extends BaseActionDelegate {
    }

    /**
     * Print message in Navigation area.
     *
     * @param message
     */
    public void print(String message);

    public void setTitle(String title);
}