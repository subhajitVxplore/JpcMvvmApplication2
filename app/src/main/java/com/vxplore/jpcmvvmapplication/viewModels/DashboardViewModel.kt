package com.vxplore.jpcmvvmapplication.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vxplore.core.common.EmitType
import com.vxplore.core.domain.model.Movies
import com.vxplore.core.domain.repositoriess.MovieRepository
import com.vxplore.core.domain.useCasess.GetPopularMoviesUseCase
import com.vxplore.jpcmvvmapplication.validator.ValidatorrUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val moviesUseCase: GetPopularMoviesUseCase
) :ViewModel() {

    val loader = mutableStateOf(false)
    val movies = mutableStateOf<Movies?>(null)
    val errors = mutableStateOf<String?>(null)

    init {
        loadSuperheroes2()
    }

    ///////from api with AppModule
    private fun loadSuperheroes2() {
        moviesUseCase.getMoviesData().onEach {
            when(it.type) {
                EmitType.Loading -> {
                    loader.value = (it.value as Boolean)
                }
                EmitType.MOVIEWS -> {
                    movies.value = (it.value as Movies)
                }
                EmitType.ERROR -> {
                    errors.value = (it.value as String)
                }
                else -> {

                }
            }
        }.launchIn(viewModelScope)
        /*_dataList2.update {
            movies
        }*/
        //_dataList2.emit(movies)
    }
}