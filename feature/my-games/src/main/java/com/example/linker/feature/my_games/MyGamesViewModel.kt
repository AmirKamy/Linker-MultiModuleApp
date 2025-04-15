package com.example.linker.feature.my_games

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.linker.core.domain.GetMyGamesUseCase
import com.example.linker.core.model.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MyGamesViewModel @Inject constructor(
    private val getMyGamesUseCase: GetMyGamesUseCase
) : ViewModel() {

    val games: StateFlow<List<Game>> = getMyGamesUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = emptyList()
    )

}