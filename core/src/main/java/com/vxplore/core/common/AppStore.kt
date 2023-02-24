package com.vxplore.core.common

interface AppStore {

    suspend fun logout()
    suspend fun isLoggedIn(): Boolean

}

