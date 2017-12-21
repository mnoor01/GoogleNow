package com.example.c4q.hw12googlenow.networking;

import com.example.c4q.hw12googlenow.model.NYT_TopStories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by bobbybah on 12/13/17.
 */

public interface NYTimesAPI {

    final static String BASE_URL= "https://api.nytimes.com";

    String NYT_Top_APIKey = "d752126a9dec4034b7f3e0e71ab84825";

<<<<<<< HEAD
    @GET("/svc/topstories/v2/{section}.json")
    Call<NYT_TopStories> getNYT_TopStories(@Path ("section") String section, @Query("apikey") String apikey);
=======
    @GET("topstories/v2/home.json?" + NYT_Top_APIKey)
    Call<NYT_TopStories> nice();//getter for NYT_TopStories object
>>>>>>> 58b17a0536e01faf5089586f5891f4b6d8fed8da
}
