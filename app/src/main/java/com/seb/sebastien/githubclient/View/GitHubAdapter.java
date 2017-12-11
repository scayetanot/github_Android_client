package com.seb.sebastien.githubclient.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.seb.sebastien.githubclient.Gists.GistsFile;
import com.seb.sebastien.githubclient.Gists.GistsFormat;
import com.seb.sebastien.githubclient.R;
import com.seb.sebastien.githubclient.Utils.TranslateTS2Time;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sebastien on 12/10/17.
 */


public final class GitHubAdapter extends RecyclerView.Adapter<GitHubGistsViewHolder> {

    private static final String TAG = GitHubAdapter.class.getSimpleName();

    public List<GistsFormat> mListOfGists;

    private Context mContext;

    public GitHubAdapter(Context context){
        this.mContext = context;
    };

    @Override
    public GitHubGistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gists_layout, parent, false);
        GitHubGistsViewHolder viewHolder = new GitHubGistsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GitHubGistsViewHolder holder, int position) {

        GistsFile mFile;

        if((mListOfGists == null) || (mListOfGists.get(position).getOwner() == null)){
            return;
        }

        mFile = getFileInformation(mListOfGists.get(position).getFiles());

        if(mListOfGists.get(position).getOwner().getAvatar_url() != null)
            Picasso.with(this.mContext).load(mListOfGists.get(position).getOwner().getAvatar_url())
                    .into(holder.avatar);

        holder.user.setText(mListOfGists.get(position).getOwner().getLogin());
        holder.date.setText(mListOfGists.get(position).getCreated_at());
        holder.file.setText(mFile.getFilename());

    }

    @Override
    public int getItemCount() {
        return (mListOfGists != null) ? mListOfGists.size() : 0;
    }

    public void updateAdapter(List<GistsFormat> listOfTopics){
        if(mListOfGists == null){
            mListOfGists = listOfTopics;
        } else {
            mListOfGists.addAll(listOfTopics);
        }
    }

    private GistsFile getFileInformation(String stringJSON){

        String file = "";
        try {
            JSONObject json = new JSONObject(stringJSON);
            Iterator<String> keys = json.keys();
            String str_Name=keys.next();
            file = json.optString(str_Name);
        } catch (JSONException e){
            Log.d(TAG, "Error message: " + e.getMessage());
        }
        GistsFile tmp = new Gson().fromJson(file, GistsFile.class);
        return tmp;
    }

}