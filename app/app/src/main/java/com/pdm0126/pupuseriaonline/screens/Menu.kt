package com.pdm0126.pupuseriaonline.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdm0126.pupuseriaonline.data.menu
import com.pdm0126.pupuseriaonline.model.Producto

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Menu(
    order: List<Producto>,
    onAdd: (Producto) -> Unit,
    navigateToOrden: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú") },
                actions = {
                    Button(onClick = navigateToOrden) {
                        Text("Orden (${order.size})")
                    }
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            items(menu) { producto ->

                val cantidad = order.count { it == producto }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onAdd(producto)
                        }
                        .padding(16.dp)
                ) {

                    Text(
                        text = producto.nombre,
                    )

                    Text("$${producto.precio}")

                    if (cantidad > 0) {
                        Text("Cantidad: $cantidad")
                    }
                }
            }
        }
    }
}