package com.pdm0126.pupuseriaonline

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.pupuseriaonline.model.Producto
import com.pdm0126.pupuseriaonline.screens.Menu
import com.pdm0126.pupuseriaonline.screens.MiOrden

@Composable
fun MainNavigation() {

    val backStack = rememberNavBackStack(Routes.Menu)

    var order by rememberSaveable{ mutableStateOf(listOf<Producto>())
    }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },

        entryProvider = entryProvider {



            entry<Routes.Menu> {

                Menu(
                    order = order,

                    onAdd = { producto ->
                        order = order + producto
                    },

                    navigateToOrden = {
                        backStack.add(Routes.Orden)
                    }
                )
            }

            entry<Routes.Orden> {

                MiOrden(
                    order = order,

                    navigateToBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        },

    )
}