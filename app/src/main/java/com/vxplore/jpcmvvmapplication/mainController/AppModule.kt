package com.vxplore.jpcmvvmapplication.mainController

import com.vxplore.core.domain.repositoriess.MovieRepository
import com.vxplore.jpcmvvmapplication.movies.MovieApi
import com.vxplore.jpcmvvmapplication.movies.MovieRepositoryImpl
import com.vxplore.jpcmvvmapplication.validator.ValidatorrImpl
import com.vxplore.jpcmvvmapplication.validator.ValidatorrUtil
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindValidation(impl: ValidatorrImpl): ValidatorrUtil


    @Binds
    abstract fun bindMovieRepo(impl: MovieRepositoryImpl): MovieRepository

    companion object {

        private fun <T> provideApi(klass: Class<T>): T {
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(klass)
        }

        @Provides
        @Singleton
        fun provideMovies(): MovieApi = provideApi(MovieApi::class.java)
    }

}