package com.vxplore.jpcmvvmapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.core.utils.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
   val appNavigator: AppNavigator,
) : ViewModel() {


}