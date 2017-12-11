package com.seb.sebastien.githubclient.Gists;

/**
 * Created by sebastien on 12/10/17.
 */

public class GistsFile {

    private String filename;
    private String type;
    private String language;
    private String raw_url;
    private int size;

    public String getFilename() {return filename;}
    public String getType() {return type;}
    public String getLanguage() {return language;}
    public String getRaw_url() {return raw_url;}
    public int getSize(){ return size; }

}
