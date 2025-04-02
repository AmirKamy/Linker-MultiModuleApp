package com.example.linker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.linker.feature.home.navigation.HomeDestination
import com.example.linker.feature.home.navigation.HomeNavGraph
import com.example.linker.feature.my_games.navigation.MyGamesDestination
import com.example.linker.feature.my_games.navigation.MyGamesNavGraph
import com.example.linker.feature.search.navigation.SearchDestination
import com.example.linker.feature.search.navigation.SearchNavGraph

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
        composable(MyGamesDestination.MyGamesScreen.route) {
            val myGamesNavController = rememberNavController()
            MyGamesNavGraph(navController = myGamesNavController)
        }
        composable(SearchDestination.SearchScreen.route) {
            val searchNavController = rememberNavController()
            SearchNavGraph(navController = searchNavController)
        }
    }
}