package com.example.c4q.hw12googlenow.networking;

import com.example.c4q.hw12googlenow.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by joannesong on 2/14/18.
 */

public interface WeatherResponse {
 //forecast/4d30ad1fdb4404483a9697588e98ac80/40.742054,%20-73.769417

    @GET("forecast/4d30ad1fdb4404483a9697588e98ac80/{location}")
    Call<WeatherModel> getWeather(@Path("location") String location);

}
