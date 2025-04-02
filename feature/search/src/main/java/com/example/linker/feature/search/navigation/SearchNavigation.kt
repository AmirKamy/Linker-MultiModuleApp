package com.example.linker.feature.search.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.linker.feature.search.SearchScreen

@Composable
fun SearchNavGraph(navController: NavHostController, startDestination: String = SearchDestination.SearchScreen.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(SearchDestination.SearchScreen.route) {
            SearchScreen()
        }

    }
}