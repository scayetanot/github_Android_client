package com.seb.sebastien.githubclient;

import com.seb.sebastien.githubclient.Gists.GistsFormat;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sebastien on 12/10/17.
 */

public class GithubEndPointAccess {
    private final static String GITHUB_URL = "https://api.github.com";

    private Retrofit mRetrofit;

    public interface GitHubEndpointService {


        @Headers("Accept: application/vnd.github.v3+json")
        @GET("/gists/public")
            Call<List<GistsFormat>> getListOfPublicGists();

    }



    public GithubEndPointAccess(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    public GitHubEndpointService getService(){
        return mRetrofit.create(GitHubEndpointService.class);
    }
}
