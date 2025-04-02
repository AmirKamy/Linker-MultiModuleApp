package com.example.linker.feature.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.linker.feature.home.HomeScreen

@Composable
fun HomeNavGraph(navController: NavHostController, startDestination: String = HomeDestination.HomeScreen.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(HomeDestination.HomeScreen.route) {
            HomeScreen()
        }

    }
}