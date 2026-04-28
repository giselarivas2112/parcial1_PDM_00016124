package com.pdm0126.pupuseriaonline.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pdm0126.pupuseriaonline.model.Producto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiOrden(
    order: List<Producto>,
    navigateToBack: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Orden") }
            )
        }
    ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(order) { producto ->

                    Text(
                        text = "${producto.nombre} - $${producto.precio}",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            Button(
                onClick = navigateToBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Volver")
            }
        }
    }
}