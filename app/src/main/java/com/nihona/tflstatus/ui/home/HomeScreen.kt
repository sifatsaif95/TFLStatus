package com.nihona.tflstatus.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nihona.tflstatus.ui.model.TubeLineEnum
import com.nihona.tflstatus.ui.theme.TFLStatusTheme

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val statusData = viewModel.data.collectAsState()
    val loading = viewModel.loading.collectAsState()
    val error = viewModel.error.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(statusData.value) {
            LineListItem(
                title = it.name,
                status = it.lineStatuses.first().statusSeverityDescription,
                color = getTubeLineColor(it.name)
            )
        }
    }

    ProgressBar(
        isLoading = loading.value,
        modifier = Modifier
    )

    GenericError(
        errorText = error.value,
        modifier = Modifier
    )
}

@Composable
@Preview(showBackground = true)
fun HomeScreePreview() {
    TFLStatusTheme {
        HomeScreen()
    }
}

fun getTubeLineColor(line: String): Color {
    when(line) {
        TubeLineEnum.BAKERLOO.value -> return Color(0xFFB36305)
        TubeLineEnum.CENTRAL.value  -> return Color(0xFFE32017)
        TubeLineEnum.CIRCLE.value  -> return Color(0xFFFFD300)
        TubeLineEnum.DISTRICT.value  -> return Color(0xFF00782A)
        TubeLineEnum.ELIZABETH.value  -> return Color(0xFF6950a1)
        TubeLineEnum.HAMMERSMITH.value  -> return Color(0xFFF3A9BB)
        TubeLineEnum.JUBILEE.value  -> return Color(0xFFA0A5A9)
        TubeLineEnum.METROPOLITAN.value  -> return Color(0xFF9B0056)
        TubeLineEnum.NORTHERN.value  -> return Color(0xFF000000)
        TubeLineEnum.PICCADILLY.value  -> return Color(0xFF003688)
        TubeLineEnum.VICTORIA.value  -> return Color(0xFF0098D4)
        TubeLineEnum.WATERLOO.value  -> return Color(0xFF95CDBA)
        TubeLineEnum.DLR.value  -> return Color(0xFF00A4A7)
        TubeLineEnum.OVERGROUND.value  -> return Color(0xFFEE7C0E)
        TubeLineEnum.TRAMS.value  -> return Color(0xFF84B817)
        TubeLineEnum.CABLECAR.value  -> return Color(0xFFE21836)
        else -> return Color.White
    }
}