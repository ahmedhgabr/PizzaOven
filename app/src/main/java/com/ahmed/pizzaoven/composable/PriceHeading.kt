package com.ahmed.pizzaoven.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceHeading(price: Int, fontSize: Int, modifier: Modifier = Modifier) {
    Text(
        text = "$$price",
        modifier = modifier
            .padding(16.dp),
        style = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    )
}


@Preview(showBackground = true)
@Composable
fun PriceHeadingPreview() {
    PriceHeading(17, 22)
}


