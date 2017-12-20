package com.example.c4q.hw12googlenow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.c4q.hw12googlenow.controller.ArticleAdapter;
import com.example.c4q.hw12googlenow.model.BBCmodel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private String sNewsAPI;
    private List<String> aNames;
    private Button openButton;
    private BBCmodel bbcModel;
    private static final String TAG="JSon testing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiClient apiClient = new ApiClient();
        //so I made a class instead of
        //Retrotfit retrofit= new Retrofit.builder().baseurl(puturl).convertToGson(GsonConcerter).build.
        Retrofit retrofit = apiClient.getClient();
        final UsersApi bbcService = retrofit.create(UsersApi.class);
        Call<BBCmodel> getBBCModel = bbcService.getModel();




        getBBCModel.enqueue(new Callback<BBCmodel>() {
            @Override
            public void onResponse(Call<BBCmodel> call, Response<BBCmodel> response) {
                bbcModel = response.body();

                Log.d(TAG,bbcModel.getArticles()[0].getAuthor());
                Log.d(TAG,bbcModel.getArticles()[0].getTitle());
                Log.d(TAG,bbcModel.getArticles()[0].getDescription());
                Log.d(TAG,bbcModel.getArticles()[0].getPublishedAt());
                Log.d(TAG,bbcModel.getArticles()[0].getUrl());


            }

            @Override
            public void onFailure(Call<BBCmodel> call, Throwable t) {
                t.printStackTrace();
            }
        });

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

               intiRec();
           }
       }, 5000);



    }

    private void intiRec() {
        RecyclerView googleRecylerView = findViewById(R.id.googlerecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArticleAdapter adapter = new ArticleAdapter(bbcModel.getArticles());
        googleRecylerView.setAdapter(adapter);
        googleRecylerView.setLayoutManager(linearLayoutManager);
    }
//From here on it is dead code


    public void nowWeAreGoingToparseAspectsInTheArticle(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray article = response.optJSONArray("articles");
            for (int i = 0; i < article.length(); i++) {
                JSONObject myArticles = article.getJSONObject(i);
                String articleTitle = myArticles.getString("title");
                aNames.add(articleTitle);
                Log.d("title", articleTitle);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
/*
I have made some changes
 */