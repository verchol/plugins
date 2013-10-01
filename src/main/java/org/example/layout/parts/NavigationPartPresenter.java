package org.example.layout.parts;

import com.codenvy.ide.api.ui.workspace.PartPresenter;
import com.codenvy.ide.api.parts.base.BasePresenter;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Template for the Navigation View Part. Used for demo and currently does nothing.
 *
 * @author <a href="mailto:nzamosenchuk@exoplatform.com">Nikolay Zamosenchuk</a>
 */
@Singleton
public class NavigationPartPresenter extends BasePresenter implements NavigationPartView.ActionDelegate, NavigationPart {
    private static final String TITLE = "Navigation Panel";
    private NavigationPartView view;

    /** Construct empty Part */
    @Inject
    public NavigationPartPresenter(NavigationPartView view) {
        this.view = view;
        this.view.setTitle(TITLE);
        this.view.setDelegate(this);
    }

    /** {@inheritDoc} */
    @Override
    public String getTitle() {
        return TITLE;
    }

    /** {@inheritDoc} */
    @Override
    public ImageResource getTitleImage() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String getTitleToolTip() {
        return "Displays Navigation panel options";
    }

    /** {@inheritDoc} */
    @Override
    public void go(AcceptsOneWidget container) {
        container.setWidget(view);
    }

    /** {@inheritDoc} */
    @Override
    public void print(String message) {
        view.print(message);
        PartPresenter activePart = partStack.getActivePart();
        if (activePart == null || !activePart.equals(this)) {
            partStack.setActivePart(this);
        }
    }
}