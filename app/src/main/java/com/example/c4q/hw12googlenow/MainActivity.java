package com.example.c4q.hw12googlenow;

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

    List<NYT_TopStories.Results> NYT_Data = new ArrayList<>();
    private static final String TAG = "Retrofit Response: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView times_recyclerView = findViewById(R.id.nyt_recyclerView);
//        List<NYT_TopStories> nyt_topStories = new ArrayList<>();

      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl("https://api.nytimes.com/svc/")
              .addConverterFactory(GsonConverterFactory.create())
              .build();

        NYTimesAPI NY_service = retrofit.create(NYTimesAPI.class);

        Call<NYT_TopStories.Results> getRecentStories = NY_service.getNYT_TopStories();

        getRecentStories.enqueue(new Callback<NYT_TopStories.Results>() {
                @Override
                public void onResponse(Call<NYT_TopStories.Results> call, Response<NYT_TopStories.Results> response) {
                    if (response.isSuccessful()){
                       NYT_TopStories.Results nytTopStories = response.body();
                       NYT_Data.add(nytTopStories);
                        Log.d(TAG, "onResponse: "+ NYT_Data);
                    }
                }

            @Override
                public void onFailure(Call<NYT_TopStories.Results> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.toString());
                }
            });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        times_recyclerView.setLayoutManager(layoutManager);
        NYT_Adapter nyt_adapter = new NYT_Adapter(NYT_Data);
        times_recyclerView.setAdapter(nyt_adapter);
    }
}
