package com.vxplore.core.domain.useCasess

import com.vxplore.core.common.Data
import com.vxplore.core.common.EmitType
import com.vxplore.core.domain.repositoriess.MovieRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GetPopularMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {


    fun getMoviesData() = flow {
        emit(Data(type = EmitType.Loading, value = true))
        val response =  movieRepository.getMoviesData()

        emit(Data(type = EmitType.Loading, value = false))
        if (response != null) {
            emit(Data(type = EmitType.MOVIEWS, value = response))
        } else {
            emit(Data(type = EmitType.ERROR, value = "Error has happen"))
        }
    }
}