package com.vxplore.jpcmvvmapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vxplore.core.domain.model.Movies
import com.vxplore.core.domain.repositoriess.MovieRepository
import com.vxplore.jpcmvvmapplication.validator.ValidatorrUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) :ViewModel() {


    init {

        viewModelScope.launch {
            loadSuperheroes2()
        }
    }

    ///////from api with AppModule
    private val _dataList2 = MutableStateFlow<Movies?>(null)
    val dataList2 = _dataList2.asStateFlow()
    private suspend fun loadSuperheroes2() {
        val movies = movieRepository.getMoviesData()
        _dataList2.update {
            movies
        }
    }
}