package acount.poly.movies_minhkt.db;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Upsert;

import acount.poly.movies_minhkt.models.FavouriteMovie;

import java.util.List;

@Dao
public interface FavouriteMoviesDao {
    @Query("SELECT * FROM favourite_movies")
    List<FavouriteMovie> getMovies();

    @Upsert
    void addMovie(FavouriteMovie movie);

    @Query("DELETE FROM favourite_movies WHERE id=:movieId")
    void removeMovie(int movieId);
}
