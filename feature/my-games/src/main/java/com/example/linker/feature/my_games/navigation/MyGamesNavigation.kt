package com.example.linker.feature.my_games.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink
import com.example.linker.feature.my_games.EditGameScreen
import com.example.linker.feature.my_games.GameDetailsScreen
import com.example.linker.feature.my_games.MyGamesScreen
import kotlinx.serialization.Serializable
@Composable
fun MyGamesNavGraph(navController: NavHostController, startDestination: String = MyGamesDestination.MyGamesScreen.route) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(MyGamesDestination.MyGamesScreen.route) {
            MyGamesScreen(onGameClick = { gameId ->
                navController.navigate(MyGamesDestination.GameDetails.createRoute(gameId))
            })
        }
        composable(MyGamesDestination.GameDetails.route) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId") ?: ""
            GameDetailsScreen(gameId = gameId, onEditClick = { id ->
                navController.navigate(MyGamesDestination.EditGame.createRoute(id))
            })
        }
        composable(MyGamesDestination.EditGame.route) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getString("gameId") ?: ""
            EditGameScreen(gameId = gameId, onSaveClick = {
                navController.popBackStack()
            })
        }
    }
}