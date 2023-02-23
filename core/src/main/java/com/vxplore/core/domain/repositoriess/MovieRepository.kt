package com.vxplore.core.domain.repositoriess

import com.vxplore.core.domain.model.Movies


interface MovieRepository {
    suspend fun getMoviesData(): Movies?

}



