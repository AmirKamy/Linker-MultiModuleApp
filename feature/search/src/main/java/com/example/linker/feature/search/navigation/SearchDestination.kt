package com.example.linker.feature.search.navigation

sealed class SearchDestination(val route: String) {
    data object SearchScreen : SearchDestination("search_screen")
}