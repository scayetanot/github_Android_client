package com.seb.sebastien.githubclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seb.sebastien.githubclient.Gists.GistsFormat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Call<List<GistsFormat>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GithubEndPointAccess myAccess = new GithubEndPointAccess();
        list = myAccess.getService().getListOfPublicGists();
        list.enqueue(new Callback<List<GistsFormat>>() {
            @Override
            public void onResponse(Call<List<GistsFormat>> call, Response<List<GistsFormat>> response) {
                for(int i  = 0; i< response.body().size(); i++){
                    System.out.println(response.body().get(i).getgOwner().getGravatar_id());
                }
            }

            @Override
            public void onFailure(Call<List<GistsFormat>> call, Throwable t) {

            }
        });


    }
}
