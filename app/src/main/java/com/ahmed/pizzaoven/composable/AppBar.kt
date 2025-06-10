package com.ahmed.pizzaoven.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.pizzaoven.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(title: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 32.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "go back",
            tint = Color.Black
        )

        Text(
            text = title,
            color = Color.Black,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Icon(
            painter = painterResource(id = R.drawable.favorite),
            contentDescription = "favorite",
            tint = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaOvenAppPreview() {
    AppBar("Pizza")
}