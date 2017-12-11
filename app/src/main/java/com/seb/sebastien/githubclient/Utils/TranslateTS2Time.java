package com.seb.sebastien.githubclient.Utils;

/**
 * Created by sebastien on 12/10/17.
 */


public abstract class TranslateTS2Time {

    public static String translateTS2Time(long seconds) {
        if(seconds < 60)
            return String.valueOf(seconds) + " sec ago";
        else if (seconds < 3600)
            return String.valueOf(seconds/60) + " min ago";
        else if (seconds < 86400)
            return String.valueOf(seconds/3600) + " hours ago";
        else if (seconds < 2628000)
            return String.valueOf(seconds/86400) + " days ago";
        else if (seconds < 31536000)
            return String.valueOf(seconds/2628000) + " months ago";
        else
            return String.valueOf(seconds/31536000) + " years ago";
    }
}

