package com.pdm0126.pupuseriaonline

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object Menu : Routes()

    @Serializable
    data object Orden : Routes()
}