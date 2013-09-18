package com.codenvy.ide.extension.apachelogger.actions;

import com.codenvy.ide.api.editor.EditorAgent;
import com.codenvy.ide.api.resources.ResourceProvider;
import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionLocalizationConstant;
import com.codenvy.ide.extension.apachelogger.ApacheLoggerExtensionResources;
import com.codenvy.ide.extension.apachelogger.configureLogger.ConfigureLoggerPresenter;
import com.codenvy.ide.resources.model.Project;
import com.codenvy.ide.resources.model.File; 
import com.codenvy.ide.rest.MimeType;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.gwt.user.client.rpc.AsyncCallback;

import com.codenvy.ide.api.parts.ConsolePart;


/**
 * Action for configuring Apache Logger
 */
@Singleton
public class ConfigureLoggerAction extends Action {

    private ConfigureLoggerPresenter configureLoggerPresenter;
    private ResourceProvider resourceProvider;
    private ConsolePart console;
    private EditorAgent editorAgent;
    
    private static final String LOG4J_CONFIG_FILENAME = "log4j.properties";
    private static final String CONFIG_FILE_CHARSET = "";

    @Inject
    public ConfigureLoggerAction(ConfigureLoggerPresenter configureLoggerPresenter,
    						ApacheLoggerExtensionResources resources,
                            ApacheLoggerExtensionLocalizationConstant localizationConstants,
                            ResourceProvider resourceProvider,
                            EditorAgent editorAgent,
                            ConsolePart console) {
        super(localizationConstants.configureLoggerActionText(), localizationConstants.configureLoggerActionDescription(), resources.icon());
        this.configureLoggerPresenter = configureLoggerPresenter;
        this.resourceProvider = resourceProvider;
        this.editorAgent = editorAgent;
        this.console = console;
        
        Project activeProject = resourceProvider.getActiveProject();
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
    	Project activeProject = resourceProvider.getActiveProject();
    	if (activeProject != null) {
    		openApacheLoggerConfigFile(activeProject);
    	} else {
    		console.print("ERROR: No project open.");
    	}
    	
    }
    
    public void openApacheLoggerConfigFile(Project project) {
    	// Find a file 
    	File log4jconfig = (File) project.findResourceByName(LOG4J_CONFIG_FILENAME, File.TYPE);
    	if (log4jconfig != null) {
    		console.print("Found file. Will open it now...");
    		editorAgent.openEditor(log4jconfig);
    	} else {
    		console.print("WARN: Could not find log4j.properties file. Will attemp to create it");
    		
            project.createFile(project, LOG4J_CONFIG_FILENAME, CONFIG_FILE_CHARSET, MimeType.TEXT_PLAIN, new AsyncCallback<File>() {
                @Override
                public void onSuccess(File result) {
                	console.print("File created successfuly.");
                	editorAgent.openEditor(result);
                }

                @Override
                public void onFailure(Throwable caught) {
                	console.print("ERROR: problem creating configuration file! Error was: " + caught.getLocalizedMessage());
                }
            });
    	}
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
