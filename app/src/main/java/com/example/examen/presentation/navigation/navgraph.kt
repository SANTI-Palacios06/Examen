package com.example.examen.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.presentation.screens.Holamundo

@Composable
fun Base(
    navController: NavHostController = rememberNavController(),)
{
    NavHost(
        navController = navController,
        startDestination = rutas.Home.name,
        //modifier = modifier,
    ){

        composable(route=rutas.Home.name){
            Holamundo(cambiarRuta = {navController.navigate(rutas.Home.name)})
        }

    }
    }