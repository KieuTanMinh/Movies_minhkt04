package acount.poly.movies_minhkt.di;

import acount.poly.movies_minhkt.apis.MoviesApi;
import acount.poly.movies_minhkt.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    MoviesApi provideMoviesApi() {
        return (new Retrofit.Builder())
            .baseUrl(Constants.MOVIE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi.class);
    }
}
