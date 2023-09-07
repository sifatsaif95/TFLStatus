package com.nihona.tflstatus.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nihona.tflstatus.ui.theme.TFLStatusTheme

@Composable
fun LineListItem(
    modifier: Modifier = Modifier,
    title: String,
    status: String,
    color: Color = Color.White
) {
    Card(
        shape = RoundedCornerShape(2.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(MaterialTheme.colorScheme.background)
        ) {

            Box(
                modifier = Modifier
                    .width(16.dp)
                    .background(color)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = status,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LineListItemPreview() {
    TFLStatusTheme {
        LineListItem(title = "Victoria", status = "Good Service")
    }
}