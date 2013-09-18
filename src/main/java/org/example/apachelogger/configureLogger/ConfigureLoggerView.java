package org.example.apachelogger.configureLogger;

import com.codenvy.ide.annotations.NotNull;
import com.codenvy.ide.api.mvp.View;

/**
 * The view of {@link ConfigureLoggerPresenter}.
 */
public interface ConfigureLoggerView extends View<ConfigureLoggerView.ActionDelegate> {
    /** Needs for delegate some function into {@link ConfigureLoggerView} view. */
    public interface ActionDelegate {
        /** Performs any actions appropriate in response to the user having pressed the Apply button. */
        void onApplyClicked();

        /** Performs any actions appropriate in response to the user having pressed the Cancel button. */
        void onCancelClicked();

        /** Performs any actions appropriate in response to the user having changed something. */
        void onValueChanged();
    }

    /** Close dialog. */
    void close();

    /** Show dialog. */
    void showDialog();
}
