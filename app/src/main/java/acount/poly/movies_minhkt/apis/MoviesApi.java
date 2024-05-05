package acount.poly.movies_minhkt.apis;

import acount.poly.movies_minhkt.models.Category;
import acount.poly.movies_minhkt.models.MovieDetail;
import acount.poly.movies_minhkt.models.TrendingMovie;
import acount.poly.movies_minhkt.models.UpcomingMovie;
import acount.poly.movies_minhkt.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApi {

    @GET("genre/movie/list?language=en")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<Category> getMovieGenres();

    @GET("trending/movie/week?language=en-US")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<TrendingMovie> getTrendingMovie();

    @GET("movie/upcoming?language=en-US")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<UpcomingMovie> getUpcomingMovie(
        @Query("page") int page
    );

    @GET("movie/popular?language=en-US")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<TrendingMovie> getMovies(
        @Query("page") int page
    );

    @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<TrendingMovie> getMoviesByGenre(
        @Query("with_genres") String genreId,
        @Query("page") int page
    );

    @GET("movie/{movie_id}?language=en-US")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<MovieDetail> getMovieDetail(
        @Path("movie_id") int movieId
    );

    @GET("search/movie?include_adult=false&language=en-US")
    @Headers("Authorization: Bearer " + Constants.ACCESS_TOKEN_AUTH)
    Call<TrendingMovie> searchMovies(
        @Query("query") String query,
        @Query("page") int page
    );
}
