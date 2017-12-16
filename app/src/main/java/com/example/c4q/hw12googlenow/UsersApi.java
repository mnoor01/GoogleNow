package com.example.c4q.hw12googlenow;

import com.example.c4q.hw12googlenow.model.BBCmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 12/15/17.
 */

public interface UsersApi {
    @GET("top-headlines?sources=bbc-sport&apiKey=75c4a1e76269460892c3bb43746f73ad")
    Call<BBCmodel> getModel();
}
