package com.example.examen.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


    @Composable
    fun Holamundo(cambiarRuta: ()->Unit) {

        Column(Modifier.fillMaxSize().padding(top = 40.dp)) {
            Row {
                //Image(painter = painterResource(R.drawable.btn_star_big_on), contentDescription = "estrella")
                Text(modifier = Modifier.padding(horizontal = 10.dp), text = "Hola")
                Text("Pedro")
                Button(onClick = { cambiarRuta() }) {
                    Text("Cambiar Ruta")
                }
            }
        }
    }

