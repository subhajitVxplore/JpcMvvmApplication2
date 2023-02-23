package com.vxplore.jpcmvvmapplication.movies

import android.util.Log
import com.vxplore.core.domain.model.Movies
import com.vxplore.core.domain.repositoriess.MovieRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movies: MovieApi
) : MovieRepository {

 

    override suspend fun getMoviesData(): Movies? {
        return try {
            val result = movies.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
            return result
        } catch (ex: HttpException) {
            Log.d("API_RESPONSE", "${ex.message()}")
             null
        } catch (ex: IOException) {
            Log.d("API_RESPONSE", "${ex.message}")
          null
        } catch (ex: Exception) {
            Log.d("API_RESPONSE", "${ex.message}")
            null
        }
    }

}