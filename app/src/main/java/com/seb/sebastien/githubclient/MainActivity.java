package com.seb.sebastien.githubclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.seb.sebastien.githubclient.EndPoints.GithubEndPointAccess;
import com.seb.sebastien.githubclient.EndPoints.GithubRetriever;
import com.seb.sebastien.githubclient.Gists.GistsFormat;
import com.seb.sebastien.githubclient.View.GitHubAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity
        implements GithubRetriever.AsyncResponse {

    private final String TAG = MainActivity.class.getSimpleName();
    public Call<List<GistsFormat>> list;

    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView rvRecyclerView;
    private GitHubAdapter gitHubAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayoutManager = new LinearLayoutManager(this);
        rvRecyclerView = findViewById(R.id.rvRecyclerView);
        rvRecyclerView.setLayoutManager(mLinearLayoutManager);

        if(gitHubAdapter == null)
            gitHubAdapter = new GitHubAdapter(this);

        rvRecyclerView.setAdapter(gitHubAdapter);
        rvRecyclerView.setHasFixedSize(true);

        new GithubRetriever(this).execute();

    }

    @Override
    public void updateMainActivity(Call<List<GistsFormat>> result){
        result.enqueue(new Callback<List<GistsFormat>>() {
            @Override
            public void onResponse(Call<List<GistsFormat>> call, Response<List<GistsFormat>> response) {
                if(gitHubAdapter != null){
                    gitHubAdapter.updateAdapter(response.body());
                    gitHubAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<GistsFormat>> call, Throwable t) {
                Log.e(TAG, "Error: "  + t.getMessage() );
            }
        });

    }
}
