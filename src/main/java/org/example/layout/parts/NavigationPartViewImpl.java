package org.example.layout.parts;

import com.codenvy.ide.api.parts.PartStackUIResources;
import com.codenvy.ide.api.parts.base.BaseView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implements {@link NavigationPartView}.
 *
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
@Singleton
public class NavigationPartViewImpl extends BaseView<NavigationPartView.ActionDelegate> implements NavigationPartView {
    private static NavigationPartViewImplUiBinder uiBinder = GWT.create(NavigationPartViewImplUiBinder.class);

    @UiField
    FlowPanel navigationArea;

    interface NavigationPartViewImplUiBinder extends UiBinder<Widget, NavigationPartViewImpl> {
    }

    @Inject
    public NavigationPartViewImpl(PartStackUIResources resources) {
        super(resources);
        container.add(uiBinder.createAndBindUi(this));
    }

    /** {@inheritDoc} */
    @Override
    public void print(String message) {
        navigationArea.add(new HTML(message));
    }
}