package com.example.linker.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.linker.core.model.DataPoint
import com.example.linker.core.model.Gold
import com.example.linker.core.model.Palladium
import com.example.linker.core.model.Platinum
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MPLineChart(
    modifier: Modifier = Modifier,
    platinum: Platinum,
    palladium: Palladium,
    gold: Gold,
    isPlatinumVisible: Boolean,
    isSilverVisible: Boolean,
    isGoldVisible: Boolean
) {
    val backgroundColor = MaterialTheme.colorScheme.surface
    val chartTextColor = MaterialTheme.colorScheme.onSurface.toArgb()
    AndroidView(
        modifier = modifier
            .fillMaxWidth()
            .height(210.dp)
            .background(MaterialTheme.colorScheme.surface),

        factory = { context ->
            LineChart(context).apply {
                setupChart(this, chartTextColor, backgroundColor.toArgb())
            }
        },
        update = { chart ->
            val dataSets = mutableListOf<ILineDataSet>()

            if (isPlatinumVisible) {
                dataSets.add(toLineDataSet(platinum.data, platinum.name, Color(platinum.color)))
            }
            if (isSilverVisible) {
                dataSets.add(toLineDataSet(palladium.data, palladium.name, Color(palladium.color)))
            }
            if (isGoldVisible) {
                dataSets.add(toLineDataSet(gold.data, gold.name, Color(gold.color)))
            }

            chart.data = LineData(dataSets)
            chart.setBackgroundColor(backgroundColor.toArgb())
            chart.invalidate()
        }
    )
}

private fun setupChart(chart: LineChart, chartTextColor: Int, chartBackgroundColor: Int) {
    chart.apply {
        description.isEnabled = false
        setTouchEnabled(true)
        setDrawGridBackground(false)
        isDragEnabled = true
        setScaleEnabled(true)
        setPinchZoom(true)
        legend.isEnabled = false
        legend.textColor = chartTextColor
        chart.extraBottomOffset = 16f
        chart.setBackgroundColor(chartBackgroundColor)



        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            valueFormatter = object : ValueFormatter() {
                private val sdf = SimpleDateFormat("dd MMM", Locale.getDefault())
                override fun getFormattedValue(value: Float): String {
                    return sdf.format(Date(value.toLong()))
                }
            }
            textColor = chartTextColor
            gridColor = android.graphics.Color.DKGRAY
            axisLineColor = android.graphics.Color.LTGRAY
        }

        axisLeft.apply {
            textColor = chartTextColor
            gridColor = android.graphics.Color.DKGRAY
            axisLineColor = android.graphics.Color.LTGRAY
        }
//        xAxis.setLabelCount(4, true)
//
//        val yAxis = chart.axisLeft
//        yAxis.setLabelCount(5, true)

        axisRight.isEnabled = false
    }
}


private fun toLineDataSet(
    points: List<DataPoint>,
    label: String,
    color: Color
): LineDataSet {
    val entries = points.map {
        Entry(it.timestamp.toFloat(), it.value)
    }
    return LineDataSet(entries, label).apply {
        this.color = color.toArgb()
        setDrawCircles(false)
        setDrawValues(false)
        lineWidth = 3f
        highLightColor = android.graphics.Color.YELLOW
        setDrawFilled(false)
    }
}


