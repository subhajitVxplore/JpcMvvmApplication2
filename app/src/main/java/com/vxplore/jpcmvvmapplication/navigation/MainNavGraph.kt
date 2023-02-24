package com.vxplore.jpcmvvmapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.core.utils.NavigationIntent
import com.example.farmologydelivery.navigation.NavEffects
import com.vxplore.core.common.AppRoutes
import com.vxplore.core.common.Destination
import com.vxplore.jpcmvvmapplication.screens.DashboardScreen
import com.vxplore.jpcmvvmapplication.screens.LoginScreen
import com.vxplore.jpcmvvmapplication.screens.SplashScreen
import kotlinx.coroutines.channels.Channel

@Composable
fun MainNavGraph(
    navHostController: NavHostController,
    navigationChannel: Channel<NavigationIntent>,
    paddingValues: PaddingValues,
) {
    navHostController.NavEffects(navigationChannel)

    AppNavHost(
        navController = navHostController,
        startDestination = Destination.Splash,
        modifier = Modifier.padding(paddingValues),
        enterTransition = AppScreenTransitions.ScreenEnterTransition,
        popEnterTransition = AppScreenTransitions.ScreenPopEnterTransition,
        exitTransition = AppScreenTransitions.ScreenExitTransition,
        popExitTransition = AppScreenTransitions.ScreenPopExitTransition,
    ) {
        composable(destination = Destination.Splash) {
            SplashScreen(navHostController)


        }
        composable(destination = Destination.Login) {
            LoginScreen(onNextClick = { navHostController.navigate(AppRoutes.DASHBOARD) }) {

            }
        }
        composable(destination = Destination.Dashboard) {
            DashboardScreen()
        }

    }
}