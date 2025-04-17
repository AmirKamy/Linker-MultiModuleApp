package com.example.linker.feature.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.linker.core.designsystem.component.MetalItem
import com.example.linker.core.model.ChartDataGroup
import com.example.linker.core.model.Resource

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.chartDataGroup.collectAsState()

    when (state) {
        is Resource.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is Resource.Error -> {
            val message = (state as Resource.Error).message
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "خطا: $message")
            }
        }

        is Resource.Success -> {
            val data = (state as Resource.Success).data
            ShowContent(data)
        }
    }

}


@Composable
fun ShowContent(
    chartDataGroup: ChartDataGroup
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        var showPlatinum by remember { mutableStateOf(true) }
        var showSilver by remember { mutableStateOf(true) }
        var showGold by remember { mutableStateOf(true) }

        Card(
            modifier = Modifier
                .padding(top = 32.dp, bottom = 24.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            Column {

                Text(
                    text = stringResource(R.string.line_view),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, end = 20.dp)
                )
                MPLineChart(
                    platinum = chartDataGroup.platinum,
                    palladium = chartDataGroup.palladium,
                    gold = chartDataGroup.gold,
                    isPlatinumVisible = showPlatinum,
                    isSilverVisible = showSilver,
                    isGoldVisible = showGold,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Text(
                    text = stringResource(R.string.value_show),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, end = 20.dp, bottom = 5.dp)
                )

                MetalItem(
                    iconItem = Color(chartDataGroup.platinum.color),
                    title = chartDataGroup.platinum.name,
                    number = chartDataGroup.platinum.data.last().value.toString(),
                    isToggled = showPlatinum,
                    onToggleChanged = { showPlatinum = it }
                )

                MetalItem(
                    iconItem = Color(chartDataGroup.palladium.color),
                    title = chartDataGroup.palladium.name,
                    number = chartDataGroup.palladium.data.last().value.toString(),
                    isToggled = showSilver,
                    onToggleChanged = { showSilver = it }
                )

                MetalItem(
                    iconItem = Color(chartDataGroup.gold.color),
                    title = chartDataGroup.gold.name,
                    number = chartDataGroup.gold.data.last().value.toString(),
                    isToggled = showGold,
                    onToggleChanged = { showGold = it }
                )
            }

        }
    }
}






