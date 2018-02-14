package com.example.c4q.hw12googlenow;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.c4q.hw12googlenow.adapter.ArticleAdapter;
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

import com.example.c4q.hw12googlenow.adapter.NYT_Adapter;
import com.example.c4q.hw12googlenow.model.NYT_TopStories;
import com.example.c4q.hw12googlenow.networking.NYTimesAPI;
import com.example.c4q.hw12googlenow.networking.WeatherRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String sNewsAPI;
    private List<String> aNames;
    private Button openButton;
    private BBCmodel bbcModel;
    private Retrofit weatherNetwork;

    List<NYT_TopStories> NYT_Data = new ArrayList<>();
    private static final String TAG = "HELP!!! ";
    String NYT_Top_APIKey = "d752126a9dec4034b7f3e0e71ab84825";
    NYT_TopStories nytTopStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherRetrofit weatherRetrofit = new WeatherRetrofit();
        weatherNetwork = weatherRetrofit.getClient();
        weatherRetrofit.getResponse(weatherNetwork);

        ApiClient apiClient = new ApiClient();
        //so I made a class instead of
        //Retrotfit retrofit= new Retrofit.builder().baseurl(puturl).convertToGson(GsonConcerter).build.
        Retrofit retrofit = apiClient.getClient();
        final UsersApi bbcService = retrofit.create(UsersApi.class);
        Call<BBCmodel> getBBCModel = bbcService.getModel();

        NYT_API_Caller();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init_Recycler();
            }
        }, 5000);


        getBBCModel.enqueue(new Callback<BBCmodel>() {
            @Override
            public void onResponse(Call<BBCmodel> call, Response<BBCmodel> response) {
                bbcModel = response.body();

                Log.d(TAG, bbcModel.getArticles()[0].getAuthor());
                Log.d(TAG, bbcModel.getArticles()[0].getTitle());
                Log.d(TAG, bbcModel.getArticles()[0].getDescription());
                Log.d(TAG, bbcModel.getArticles()[0].getPublishedAt());
                Log.d(TAG, bbcModel.getArticles()[0].getUrl());


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
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ArticleAdapter adapter = new ArticleAdapter(bbcModel.getArticles());
        googleRecylerView.setAdapter(adapter);
        googleRecylerView.setLayoutManager(linearLayoutManager);
    }
//From here on it is dead code


    @SuppressLint("NewApi")
    public class asyncHTTPForSports extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... myURL) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(myURL[0]);
                urlConnection = (HttpURLConnection) url.openConnection();//creating a new url and creating the connection to the internet
                String response = streamToString(urlConnection.getInputStream());//we are getting the input from the url and passing to the method.
                nowWeAreGoingToparseAspectsInTheArticle(response);// we are taking the string which is a json adn parsing it.
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public String streamToString(InputStream stream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));//we are putting the inputstream from the url
        //in to the bufferreader
        String data;
        String result = " ";
        while ((data = bufferedReader.readLine()) != null) {// the while is creating the string from the bufferreader
            result += data;


        }
        if (null != stream) {// when there is nothing else in the bufferreader we  are closing the link
            stream.close();
        }
        return result;


    }


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


    public void NYT_API_Caller() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NYTimesAPI NY_service = retrofit.create(NYTimesAPI.class);
        Call<NYT_TopStories> getRecentStories = NY_service.getNYT_TopStories("home", NYT_Top_APIKey);
        getRecentStories.enqueue(new Callback<NYT_TopStories>() {
            @Override
            public void onResponse(Call<NYT_TopStories> call, Response<NYT_TopStories> response) {
                if (response.isSuccessful()) {
                    nytTopStories = response.body();
                    NYT_Data.add(nytTopStories);
                    nytTopStories.getResults();
                    Log.d(TAG, "onResponse: " + NYT_Data);
                }
            }

            @Override
            public void onFailure(Call<NYT_TopStories> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
    }

    public void init_Recycler() {
        RecyclerView times_recyclerView = findViewById(R.id.nyt_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        times_recyclerView.setLayoutManager(layoutManager);
        NYT_Adapter nyt_adapter = new NYT_Adapter(nytTopStories.getResults());
        times_recyclerView.setAdapter(nyt_adapter);
    }
}
/*
I have made some changes
 */