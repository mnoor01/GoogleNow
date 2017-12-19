package com.example.c4q.hw12googlenow.networking;

import com.example.c4q.hw12googlenow.model.NYT_TopStories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bobbybah on 12/13/17.
 */

public interface NYTimesAPI {

    String NYT_Top_APIKey = "d752126a9dec4034b7f3e0e71ab84825";

    @GET("topstories/v2/home.json?" + NYT_Top_APIKey)
    Call<NYT_TopStories.Results> getNYT_TopStories();
}
