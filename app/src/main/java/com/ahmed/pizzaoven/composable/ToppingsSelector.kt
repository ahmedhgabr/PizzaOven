package com.ahmed.pizzaoven.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.pizzaoven.data.Toppings
import com.ahmed.pizzaoven.data.getToppingIcon
import com.ahmed.pizzaoven.viewmodel.PizzaState

@Composable
fun ToppingsSelector(
    state: PizzaState,
    hasTopping: (Toppings) -> Boolean,
    addTopping: (Toppings) -> Unit,
    removeTopping: (Toppings) -> Unit,
    updatePrice: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 32.dp, bottom = 32.dp)
    ) {
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFABABAB)
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            Toppings.entries.forEach { topping ->

                var isSelecte = state.pizzaList[state.currentIndex].toppings.contains(topping)
                ToppingButton(
                    state = state,
                    image = getToppingIcon(topping),
                    isss= isSelecte,
                    isSelected = { hasTopping(topping) },
                    addTopping = { addTopping(topping) },
                    removeTopping = { removeTopping(topping) },
                    updatePrice = { updatePrice(0) },
                )
            }
        }
    }
}


@Composable
fun ToppingButton(
    state: PizzaState,
    image: Int,
    isss : Boolean,
    isSelected: () -> Boolean,
    addTopping: () -> Unit,
    removeTopping: () -> Unit,
    updatePrice: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .shadow(elevation = if(isss)4.dp else 0.dp, shape = CircleShape)
    ) {
        Button(
            onClick = {
                if (isSelected()) {
                    removeTopping()
                } else {
                    addTopping()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelected()) Color(0xFFDFFAE0) else Color.White
            ),
            modifier = modifier
                .size(70.dp),
//                .shadow(elevation = 4.dp, shape = CircleShape)
//                .background(if (isSelected()) Color(0xFFDFFAE0) else Color.White),
            shape = CircleShape
        ) {}

        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToppingsSelectorPreview() {
    ToppingsSelector(
        state = PizzaState(),
        addTopping = {},
        removeTopping = {},
        updatePrice = {},
        hasTopping = { false },
        modifier = Modifier
    )
}


