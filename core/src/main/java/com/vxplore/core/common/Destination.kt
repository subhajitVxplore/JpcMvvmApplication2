package com.vxplore.core.common

import android.util.Log

sealed class Destination(protected val route: String, vararg arguments: Any) {

    val fullRoute: String = if (arguments.isEmpty()) route else {
        val builder = StringBuilder(route)
        arguments.forEach { builder.append("/{${it}}") }
        Log.e("FullRoute", builder.toString())
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    object Splash : NoArgumentsDestination(AppRoutes.SPLASH)
    object Login : NoArgumentsDestination(AppRoutes.LOGIN)
    object Dashboard : NoArgumentsDestination(AppRoutes.DASHBOARD)


}