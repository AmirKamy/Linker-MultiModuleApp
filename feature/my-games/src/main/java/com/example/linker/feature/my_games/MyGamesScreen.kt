package com.example.linker.feature.my_games

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.linker.core.ui.GameCard

@Composable
fun MyGamesScreen(
    onGameClick: (String) -> Unit,
    myGamesViewModel: MyGamesViewModel = hiltViewModel()
) {
    val games by myGamesViewModel.games.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(games) { game ->
            GameCard(game = game, onClick = { onGameClick(game.id) })
        }
    }
}