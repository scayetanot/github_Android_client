package com.seb.sebastien.githubclient.EndPoints;

import android.Manifest;
import android.os.AsyncTask;
import android.util.Log;

import com.seb.sebastien.githubclient.Gists.GistsFormat;
import com.seb.sebastien.githubclient.MainActivity;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;

/**
 * Created by sebastien on 12/10/17.
 */

public class GithubRetriever extends AsyncTask<String, Void, Call<List<GistsFormat>>> {

    private static final String TAG = GithubRetriever.class.getSimpleName();

    private final WeakReference<MainActivity> activityWeakReference;

    public GithubRetriever(MainActivity activity) {
        activityWeakReference = new WeakReference<>(activity);
    }

    @Override
    protected Call<List<GistsFormat>> doInBackground(String... params) {
        return new GithubEndPointAccess().getService().getListOfPublicGists();
    }

    @Override
    protected void onPostExecute(Call<List<GistsFormat>> gistsList) {
        if (activityWeakReference == null || gistsList == null) {
            return;
        }
        activityWeakReference.get().updateMainActivity(gistsList);
    }

    public interface AsyncResponse {
        void updateMainActivity(Call<List<GistsFormat>> result);
    }
}