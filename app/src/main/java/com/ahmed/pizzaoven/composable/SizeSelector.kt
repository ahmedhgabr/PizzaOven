package com.ahmed.pizzaoven.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.pizzaoven.viewmodel.PizzaState

@Composable
fun SizeSelector(
    state: PizzaState,
    updateSize: (Int) -> Unit,
    updatePrice: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        val selectedSize = state.pizzaList[state.currentIndex].size
        val small = 0
        val medium = 5
        val large = 10
        SizeButton("S", { updateSize(small) }, selectedSize == 0)
        SizeButton("M", { updateSize(medium) }, selectedSize == 5)
        SizeButton("L", { updateSize(large) }, selectedSize == 10)
    }

}


@Composable
fun SizeButton(
    size: String,
    updateSize: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { updateSize() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .padding(8.dp)
            .size(55.dp)
            .shadow(elevation = if (isSelected) 4.dp else 0.dp, shape = CircleShape),
        shape = CircleShape
    ) {
        Text(
            text = size,
            modifier = Modifier
                .background(color = Color.White),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SizeSelectorPreview() {
    SizeSelector(
        updateSize = {},
        updatePrice = {},
        state = PizzaState(),
        modifier = Modifier
    )
}


