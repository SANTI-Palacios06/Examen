package com.example.examen.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen.presentation.screens.home.HomeScreen
import com.example.examen.presentation.screens.detail.CountryDetailScreen

@Composable
fun Base(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = rutas.Home.name,
    ) {
        composable(route = rutas.Home.name) {
            HomeScreen(
                onCountryClick = { countryName ->
                    navController.navigate("${rutas.CountryDetail.name}/$countryName")
                }
            )
        }

        composable(route = "${rutas.CountryDetail.name}/{countryName}") { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
            CountryDetailScreen(
                countryName = countryName,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}