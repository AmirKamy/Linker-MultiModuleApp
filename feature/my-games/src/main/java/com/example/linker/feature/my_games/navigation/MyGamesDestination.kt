package com.example.linker.feature.my_games.navigation

sealed class MyGamesDestination(val route: String) {
    data object MyGamesScreen : MyGamesDestination("my_games_screen")
    data object GameDetails : MyGamesDestination("game_details/{gameId}") {
        fun createRoute(gameId: String) = "game_details/$gameId"
    }
    data object EditGame : MyGamesDestination("edit_game/{gameId}") {
        fun createRoute(gameId: String) = "edit_game/$gameId"
    }
}