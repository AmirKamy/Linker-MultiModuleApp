package com.example.linker.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import com.example.linker.core.model.ChartDataGroup
import com.example.linker.core.model.DataPoint

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val chartData by viewModel.chartDataGroup.collectAsState()

//    Column(modifier = Modifier.padding(16.dp)) {
//        chartData.let { data ->
//            Text("platinum: ${data.platinum.size} points")
//            Text("silver: ${data.silver.size} points")
//            Text("gold: ${data.gold.size} points")
//        }
//    }

    AnimatedLineChart(chartData)

}


@Composable
fun AnimatedLineChart(
    chartDataGroup: ChartDataGroup,
    modifier: Modifier = Modifier
) {
    val animationProgress = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        animationProgress.animateTo(1f, tween(durationMillis = 1000))
    }

    var selectedPoint by remember { mutableStateOf<DataPoint?>(null) }

    val allData = chartDataGroup.platinum + chartDataGroup.silver + chartDataGroup.gold
    val xValues = allData.map { it.timestamp }
    val yValues = allData.map { it.value }
    if (xValues.isEmpty() || yValues.isEmpty()) return

    val minX = xValues.minOrNull() ?: 0L
    val maxX = xValues.maxOrNull() ?: 1L
    val minY = yValues.minOrNull() ?: 0f
    val maxY = yValues.maxOrNull() ?: 1f

    Box(modifier = modifier.padding(16.dp)) {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val width = size.width
                    val height = size.height
                    val clickedPoint = allData.minByOrNull { dp ->
                        val x = ((dp.timestamp - minX).toFloat() / (maxX - minX)) * width
                        val y = height - ((dp.value - minY) / (maxY - minY)) * height * animationProgress.value
                        Offset(x, y).getDistanceTo(offset)
                    }
                    selectedPoint = clickedPoint
                }
            }) {

            val width = size.width
            val height = size.height

            fun drawLineForDataset(dataset: List<DataPoint>, color: Color) {
                for (i in 1 until dataset.size) {
                    val p1 = dataset[i - 1]
                    val p2 = dataset[i]
                    val x1 = ((p1.timestamp - minX).toFloat() / (maxX - minX)) * width
                    val y1 = height - ((p1.value - minY) / (maxY - minY)) * height * animationProgress.value
                    val x2 = ((p2.timestamp - minX).toFloat() / (maxX - minX)) * width
                    val y2 = height - ((p2.value - minY) / (maxY - minY)) * height * animationProgress.value
                    drawLine(color, Offset(x1, y1), Offset(x2, y2), strokeWidth = 4f)
                }
            }

            drawLineForDataset(chartDataGroup.platinum, Color.Red)
            drawLineForDataset(chartDataGroup.silver, Color.Green)
            drawLineForDataset(chartDataGroup.gold, Color.Blue)

            selectedPoint?.let { dp ->
                val x = ((dp.timestamp - minX).toFloat() / (maxX - minX)) * width
                val y = height - ((dp.value - minY) / (maxY - minY)) * height * animationProgress.value

                drawCircle(Color.Black, radius = 8f, center = Offset(x, y))
                drawIntoCanvas { canvas ->
                    val text = "${dp.value}"
                    val paint = android.graphics.Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 32f
                        isAntiAlias = true
                    }
                    canvas.nativeCanvas.drawText(
                        text,
                        x + 10f,
                        y - 20f,
                        paint
                    )
                }
            }
        }
    }
}

private fun Offset.getDistanceTo(other: Offset): Float {
    return (this - other).getDistance()
}