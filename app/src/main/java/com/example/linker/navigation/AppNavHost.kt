package com.example.linker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.navArgument
import com.example.linker.feature.home.HomeScreen
import com.example.linker.feature.home.HomeViewModel
import com.example.linker.feature.home.ProductDetailScreen
import com.example.linker.feature.home.navigation.HomeDestination

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.HomeScreen.route
    ) {
        composable(HomeDestination.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(viewModel = viewModel, navController = navController) {
                navController.navigate(HomeDestination.DetailScreen.route)
            }
        }

        composable(
            route = HomeDestination.DetailScreen.route
        ) { backStackEntry ->
            // گرفتن parent
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(HomeDestination.HomeScreen.route)
            }

            // گرفتن sharedViewModel از parent
            val viewModel: HomeViewModel = hiltViewModel(parentEntry)

            ProductDetailScreen(viewModel = viewModel, navController = navController)
        }
    }
}
