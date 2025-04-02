package com.example.linker.feature.my_games

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyGamesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}