package nyc.c4q.moviehomework.rest;

import nyc.c4q.moviehomework.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by joannesong on 12/20/17.
 */

public interface MovieApiService {

    String api_key = "5fcbe99efbc0c30cf6b84ae06a8fa809";

    @GET("movie/top_rated?api_key=")
    Call<MovieResponse> getTopRatedMovies(@Query(api_key) String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query(api_key) String apiKey);

}
