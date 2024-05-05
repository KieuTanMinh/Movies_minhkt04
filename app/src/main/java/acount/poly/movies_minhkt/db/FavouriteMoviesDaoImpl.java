package acount.poly.movies_minhkt.db;

import android.content.Context;

import acount.poly.movies_minhkt.models.FavouriteMovie;

import java.util.List;

public class FavouriteMoviesDaoImpl {
    LocalDB db;
    FavouriteMoviesDao dao;

    public FavouriteMoviesDaoImpl(Context context) {
        db = LocalDB.getInstance(context);
        dao = db.getFavouriteMoviesDao();
    }

    public List<FavouriteMovie> getFavouriteMovies() {
        return dao.getMovies();
    }

    public void addFavouriteMovies(FavouriteMovie movie) {
        dao.addMovie(movie);
    }

    public void removeFavouriteMovies(int id) {
        dao.removeMovie(id);
    }
}
