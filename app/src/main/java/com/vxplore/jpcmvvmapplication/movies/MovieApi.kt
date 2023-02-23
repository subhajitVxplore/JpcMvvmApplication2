package com.vxplore.jpcmvvmapplication.movies

import com.vxplore.core.domain.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("popular?")
    suspend fun getPopularMovies(@Query("api_key") api_key : String) : Movies
}