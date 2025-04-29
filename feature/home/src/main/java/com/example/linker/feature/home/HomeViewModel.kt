package com.example.linker.feature.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.repository.DataPointsRepository
import com.example.linker.core.model.ChartDataGroup
import com.example.linker.core.model.Product
import com.example.linker.core.model.Resource
import com.linker.core.domain.GetChartDataGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDataPointsUseCase: GetChartDataGroupUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {

            getDataPointsUseCase()
                .catch { e ->
                    _chartDataGroup.value = Resource.Error(e.message ?: "خطا در دریافت داده")
                }
                .collect { chartGroup ->
                    _chartDataGroup.value = Resource.Success(chartGroup)
                }
        }
    }

    private val _chartDataGroup = MutableStateFlow<Resource<List<Product>>>(Resource.Loading)
    val chartDataGroup: StateFlow<Resource<List<Product>>> = _chartDataGroup

    var selectedProduct by mutableStateOf<Product?>(null)

    fun selectProduct(product: Product){
        selectedProduct = product
    }





}