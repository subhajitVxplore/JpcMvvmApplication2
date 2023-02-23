package com.vxplore.jpcmvvmapplication.navigation

import com.example.core.utils.AppNavigator
import com.example.farmologydelivery.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Singleton
    @Binds
    fun bindNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}