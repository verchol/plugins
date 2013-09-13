package com.codenvy.ide.extension.demo.actions;

import com.codenvy.ide.api.ui.action.Action;
import com.codenvy.ide.api.ui.action.ActionEvent;
import com.codenvy.ide.api.parts.ConsolePart;
import com.codenvy.ide.api.editor.EditorAgent;
import com.codenvy.ide.api.editor.EditorPartPresenter;
import com.codenvy.ide.api.preferences.PreferencesManager;
import com.codenvy.ide.api.resources.ResourceProvider;
import com.codenvy.ide.extension.demo.GistExtensionLocalizationConstant;
import com.codenvy.ide.extension.demo.GistExtensionResources;
import com.codenvy.ide.extension.demo.createGist.CreateGistPresenter;
import com.codenvy.ide.extension.demo.GistExtensionLocalizationConstant;
import com.codenvy.ide.resources.model.File;
import com.codenvy.ide.resources.model.Property;
import com.codenvy.ide.resources.model.Project;
import com.codenvy.ide.resources.model.ProjectNature;
import com.codenvy.ide.json.JsonStringSet;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Action for creating Gist on GitHub.
 */
@Singleton
public class CreateGistAction extends Action {

    private static final String               GIT_HUB_GISTS_PROPERTY_KEY   = "github_gists";
    private static final String               GIT_HUB_GISTS_API            = "https://api.github.com/gists";
    private static final String               GIT_HUB_ANONYMOUS_GISTS_HOST = "gist.github.com/anonymous";    
    
    private CreateGistPresenter createGistPresenter;
    private EditorAgent editorAgent;
    private ResourceProvider resourceProvider;
    private PreferencesManager prefs;
    private GistExtensionLocalizationConstant constant;
    private ConsolePart console;

    @Inject
    public CreateGistAction(GistExtensionResources resources,
                            CreateGistPresenter createGistPresenter,
                            EditorAgent editorAgent,
                            ResourceProvider resourceProvider,
                            PreferencesManager prefs,
                            ConsolePart console,
                            GistExtensionLocalizationConstant localizationConstants) {
        super(localizationConstants.createGistActionText(), localizationConstants.createGistActionDescription(), resources.github());
        this.editorAgent = editorAgent;
        this.resourceProvider = resourceProvider;
        this.prefs = prefs;
        this.createGistPresenter = createGistPresenter;
        this.constant = localizationConstants;
        this.console = console;
    }

    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(ActionEvent e) {
        EditorPartPresenter textEditor = editorAgent.getActiveEditor();

        if (resourceProvider != null) {
            // Get primary Nature
            JsonStringSet natures = resourceProvider.getActiveProject().getDescription().getNatures();
            for (String natureId : natures.getKeys().asIterable()) {
                console.print("NatureID: " + natureId);
                ProjectNature nat = resourceProvider.getNature(natureId);
                if (nat != null) {
                    console.print(nat.getLabel());
                } else {
                    console.print("Nature is null");
                }
            }
        } else {
            console.print("resource provider is null");
        }

        if (textEditor != null) {
            console.print("Got text editor");
            console.print(textEditor.toString());
            
            if (textEditor.getEditorInput() != null) {
                console.print("got editor input");
                if (textEditor.getEditorInput().getFile() != null) {
                    console.print("Got file");
                    if (textEditor.isDirty()) {
                        console.print("is dirty");
                        Window.alert("Please save the file before continuing.");
                    } else {
                        console.print("is not dirty");
                        console.print("posting gist");
                        doPostGist(textEditor.getEditorInput().getFile());
                    }
                } else {
                    console.print("didn't get file");
                }
            } else {
                console.print("editor input is null");
            }           
        } else {
            console.print("text editor is null");
        }
    }
    
    private void doPostGist(File file) {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, GIT_HUB_GISTS_API);
        try {
            builder.sendRequest(getRequestData(file), new RequestCallback() {
                public void onResponseReceived(Request request, Response response) {
                    JSONObject json = JSONParser.parseStrict(response.getText()).isObject();
                    if (json == null) {
                        Window.alert(constant.detectGistIdError());
                        return;
                    }
                    afterGistCreated(json.get("id").isString().stringValue());
                }

                public void onError(Request request, Throwable exception) {
                    Window.alert(constant.createGistError());
                }
            });
        } catch (RequestException e) {
            Window.alert(constant.createGistError());
        }
    }
    
    private String getRequestData(File file) {
        final String title = "Sample snippet from file " + file.getName();
        final String content = file.getContent();
        final String description = "This snippet created from file " + file.getName() + " with Codenvy";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", new JSONString(description));
        jsonObject.put("public", JSONBoolean.getInstance(true));
        JSONObject filesJsonObject = new JSONObject();
        JSONObject contentJsonObject = new JSONObject();
        contentJsonObject.put("content", new JSONString(content));
        jsonObject.put("files", filesJsonObject);
        filesJsonObject.put(title, contentJsonObject);

        return jsonObject.toString();
    }

    private void afterGistCreated(String gistId) {
        UrlBuilder builder = new UrlBuilder();
        final String url = builder.setProtocol("https").setHost(GIT_HUB_ANONYMOUS_GISTS_HOST + "/" + gistId).buildString();
        console.print("Your Gist available on " + "<a href=\"" + url + "\" target=\"_blank\">" + url + "</a>");
        addToPreferences(url);
    }
    
    private void addToPreferences(String url) {
        String githubGists = prefs.getValue(GIT_HUB_GISTS_PROPERTY_KEY);
        JSONArray json;
        if (githubGists == null || githubGists.isEmpty()) {
            json = new JSONArray();
        } else {
            json = JSONParser.parseStrict(githubGists).isArray();
            if (json != null) {
                console.print("Current urls in properties:");
                for(int i=0; i < json.size(); i++) {
                    console.print(json.get(i).toString());
                }
            } else {
                console.print("Something is wrong with old urls... recreating");
                json = new JSONArray();
            }
        }
        console.print("Adding url to properties: " + url);
        json.set(json.size(), new JSONString(url));
        console.print("Saving JSON...");
        console.print(json.toString());
        githubGists = json.toString();
        prefs.setPreference(GIT_HUB_GISTS_PROPERTY_KEY, githubGists);
        
        prefs.flushPreferences(new AsyncCallback<Void>() {
            @Override
            public void onSuccess(Void v) {
                console.print("SUCCESS: Preferences persisted on the server");
            }

            @Override
            public void onFailure(Throwable caught) {
                console.print("ERROR: Problem persisting preferences! Error was: " + caught.getLocalizedMessage());
            }
        });        
    }

    /** {@inheritDoc} */
    @Override
    public void update(ActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
