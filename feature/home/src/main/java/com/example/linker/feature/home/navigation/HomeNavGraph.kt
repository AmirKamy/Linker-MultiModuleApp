package com.example.linker.feature.home.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.linker.feature.home.HomeScreen
import com.example.linker.feature.home.HomeViewModel
import com.example.linker.feature.home.ProductDetailScreen

@Composable
fun HomeNavGraph(navController: NavHostController, startDestination: String = HomeDestination.HomeScreen.route) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HomeDestination.HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(viewModel = viewModel) { id ->
                navController.navigate(HomeDestination.DetailScreen.createRoute(id))
            }
        }

        composable(
            route = HomeDestination.DetailScreen.route,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val viewModel: HomeViewModel = hiltViewModel()
            val productId = backStackEntry.arguments?.getInt("productId") ?: return@composable
            ProductDetailScreen(productId = productId, viewModel = viewModel, navController = navController)
        }
    }
}