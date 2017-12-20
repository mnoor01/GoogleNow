package com.example.c4q.hw12googlenow;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import com.example.c4q.hw12googlenow.adapter.NYT_Adapter;
import com.example.c4q.hw12googlenow.model.NYT_TopStories;
import com.example.c4q.hw12googlenow.networking.NYTimesAPI;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<NYT_TopStories> NYT_Data = new ArrayList<>();
    private static final String TAG = "HELP!!! ";
    String NYT_Top_APIKey = "d752126a9dec4034b7f3e0e71ab84825";
    NYT_TopStories nytTopStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NYT_API_Caller();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init_Recycler();
            }
        }, 5000);
    }



       public void NYT_API_Caller(){
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

        public void init_Recycler(){
        RecyclerView times_recyclerView = findViewById(R.id.nyt_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        times_recyclerView.setLayoutManager(layoutManager);
        NYT_Adapter nyt_adapter = new NYT_Adapter(nytTopStories.getResults());
        times_recyclerView.setAdapter(nyt_adapter);
        }
}
