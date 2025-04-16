package com.example.linker.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.linker.core.model.ChartDataGroup
import com.linker.core.domain.GetChartDataGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDataPointsUseCase: GetChartDataGroupUseCase
) : ViewModel() {

    val chartDataGroup : StateFlow<ChartDataGroup> = getDataPointsUseCase()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            ChartDataGroup(emptyList(), emptyList(), emptyList()),
        )

}