package com.example.c4q.hw12googlenow.networking;

import android.util.Log;

import com.example.c4q.hw12googlenow.model.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joannesong on 2/14/18.
 */

public class WeatherRetrofit {
    public static final String BASE_URL = "https://api.darksky.net/";
    private static Retrofit retrofit = null;
    private static WeatherModel weatherBody;
    private static List<WeatherModel> weatherList;

    public  Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public void getResponse(Retrofit retrofit){
        WeatherResponse weatherResponse = retrofit.create(WeatherResponse.class);
        Call<WeatherModel> weatherModelCall = weatherResponse.getWeather("40.742054,%20-73.769417");
        weatherModelCall.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
//                weatherBody = response.body();
//                weatherList.add(weatherBody);
                Log.e("Weather", "WeatherWin");
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

                Log.e("Weather", "WeatherFail");
            }
        });
    }
}
