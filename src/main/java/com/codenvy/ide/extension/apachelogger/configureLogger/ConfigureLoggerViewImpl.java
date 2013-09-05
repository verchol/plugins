package com.codenvy.ide.extension.apachelogger.configureLogger;

import com.codenvy.ide.annotations.NotNull;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionLocalizationConstant;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The implementation of {@link ConfigureLoggerView}.
 */
@Singleton
public class ConfigureLoggerViewImpl extends DialogBox implements ConfigureLoggerView {
    interface ConfigureLoggerViewImplUiBinder extends UiBinder<Widget, ConfigureLoggerViewImpl> {
    }

    private static ConfigureLoggerViewImplUiBinder   ourUiBinder = GWT.create(ConfigureLoggerViewImplUiBinder.class);

    @UiField
    CheckBox                                publicField;
    @UiField
    TextArea                                myTextField;
    @UiField
    com.codenvy.ide.ui.Button               btnApply;
    @UiField
    com.codenvy.ide.ui.Button               btnCancel;
    @UiField(provided = true)
    final ApacheLoggerExtensionResources            res;
    @UiField(provided = true)
    final ApacheLoggerExtensionLocalizationConstant locale;
    private ActionDelegate                  delegate;

    /**
     * Create view.
     * 
     * @param resources
     * @param locale
     */
    @Inject
    protected ConfigureLoggerViewImpl(ApacheLoggerExtensionResources resources, ApacheLoggerExtensionLocalizationConstant locale) {
        this.res = resources;
        this.locale = locale;

        Widget widget = ourUiBinder.createAndBindUi(this);

        this.setText("My Title");
        this.setWidget(widget);
    }

    /** {@inheritDoc} */
    @Override
    public void close() {
        this.hide();
    }

    /** {@inheritDoc} */
    @Override
    public void showDialog() {
        this.center();
        this.show();
    }

    /** {@inheritDoc} */
    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @UiHandler("btnApply")
    public void onCommitClicked(ClickEvent event) {
        delegate.onApplyClicked();
    }

    @UiHandler("btnCancel")
    public void onCancelClicked(ClickEvent event) {
        delegate.onCancelClicked();
    }
    
    @UiHandler("myTextField")
    public void onMessageChanged(KeyUpEvent event) {
        delegate.onValueChanged();
    }
}

