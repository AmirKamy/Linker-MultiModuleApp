package com.example.linker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.linker.feature.home.navigation.HomeDestination
import com.example.linker.feature.home.navigation.HomeNavGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.HomeScreen.route
    ) {
        composable(HomeDestination.HomeScreen.route) {
            val homeNavController = rememberNavController()
            HomeNavGraph(navController = homeNavController)
        }
    }
}