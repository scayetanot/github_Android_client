package com.seb.sebastien.githubclient.Gists;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by sebastien on 12/10/17.
 */

public class GistsFormat {
    private static final String TAG = GistsFormat.class.getSimpleName();

    private String url;
    private String forks_url;
    private String commits_url;
    private String id;
    private String description;
    private GistsOwner owner;
    private String user;
    private JsonElement files;
    private boolean truncated;
    private int comments;
    private String comments_url;
    private String html_url;
    private String git_pull_url;
    private String git_push_url;
    private String created_at;
    private String updated_at;

    public String getUrl(){return url;}
    public String getForks_url(){return forks_url;}
    public String getCommits_url(){return commits_url;}
    public String getId(){return id;}
    public String getDescription(){return description;}
    public GistsOwner getOwner(){return owner;}
    public String getUser(){return user;}
    public String getFiles(){
        return files.getAsJsonObject().toString();
    }
    public boolean getTruncated(){return truncated;}
    public int getComments(){return comments;}
    public String getComments_url(){return comments_url;}
    public String getHtml_url(){return html_url;}
    public String getGit_pull_url(){return git_pull_url;}
    public String getGit_push_url(){return git_push_url;}
    public String getCreated_at(){return created_at;}
    public String getUpdated_at(){return updated_at;}


}

