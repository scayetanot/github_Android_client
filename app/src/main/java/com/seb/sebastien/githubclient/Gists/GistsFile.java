package com.seb.sebastien.githubclient.Gists;

/**
 * Created by sebastien on 12/10/17.
 */

public class GistsFile {

    private int size;
    private String raw_url;
    private String type;
    private boolean truncated;
    private String language;

    public int getSize(){ return size; }
    public String getRaw_url() {return raw_url;}
    public String getType() {return type;}
    public boolean getTruncated() {return truncated;}
    public String getLanguage() {return language;}

}
