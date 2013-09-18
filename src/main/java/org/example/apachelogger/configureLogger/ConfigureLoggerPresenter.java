package org.example.apachelogger.configureLogger;

import com.codenvy.ide.api.parts.ConsolePart;
import org.example.apachelogger.ApacheLoggerExtensionLocalizationConstant;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Presenter for configuring Apache logger
 */

@Singleton
public class ConfigureLoggerPresenter implements ConfigureLoggerView.ActionDelegate {

    private ConfigureLoggerView                    view;
    private ApacheLoggerExtensionLocalizationConstant constant;
    private ConsolePart                       console;

    /**
     * Create presenter.
     * 
     * @param view
     * @param console
     * @param constant
     */
    @Inject
    public ConfigureLoggerPresenter(ConfigureLoggerView view, ConsolePart console,
                               ApacheLoggerExtensionLocalizationConstant constant) {
        this.view = view;
        this.view.setDelegate(this);
        this.console = console;
        this.constant = constant;
    }

    /** Show dialog. */
    public void showDialog() {
        view.showDialog();
    }

    /** {@inheritDoc} */
    @Override
    public void onApplyClicked() {
        Window.alert("Hello World!");
        view.close();
    }

    /** {@inheritDoc} */
    @Override
    public void onCancelClicked() {
        view.close();
    }

    /** {@inheritDoc} */
    @Override
    public void onValueChanged() {
        this.console.print("value changed...");
    }
}
