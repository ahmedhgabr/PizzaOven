package com.ahmed.pizzaoven

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.pizzaoven.composable.AppBar
import com.ahmed.pizzaoven.composable.CartButton
import com.ahmed.pizzaoven.composable.PizzaDisplay
import com.ahmed.pizzaoven.composable.PriceHeading
import com.ahmed.pizzaoven.composable.SizeSelector
import com.ahmed.pizzaoven.composable.ToppingsSelector
import com.ahmed.pizzaoven.data.Toppings
import com.ahmed.pizzaoven.ui.theme.PizzaOvenTheme
import com.ahmed.pizzaoven.viewmodel.PizzaState
import com.ahmed.pizzaoven.viewmodel.PizzaViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PizzaOvenApp(
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state by viewModel.pizzaState.collectAsState()
    PizzaOvenAppContent(
        state = state,
        updateCurrentPizza = viewModel::updateCurrentIndex,
        updateSize = viewModel::updateSize,
        hasTopping = viewModel::hasTopping,
        addTopping = viewModel::addTopping,
        removeTopping = viewModel::removeTopping,
        updatePrice = viewModel::updatePrice,
        addToCart = viewModel::addToCart,
    )
}

@Composable
fun PizzaOvenAppContent(
    state: PizzaState,
    updateCurrentPizza: (Int) -> Unit,
    updateSize: (Int) -> Unit,
    hasTopping: (Toppings) -> Boolean,
    addTopping: (Toppings) -> Unit,
    removeTopping: (Toppings) -> Unit,
    updatePrice: (Int) -> Unit,
    addToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    PizzaOvenTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
                .background(color = Color.White)
        ) {
            AppBar("Pizza")
            PizzaDisplay(state, updateCurrentPizza)
            PriceHeading(price = 17, fontSize = 22)
            SizeSelector(state, updateSize, updatePrice)
            ToppingsSelector(state, hasTopping, addTopping, removeTopping, updatePrice)
            Spacer(modifier = Modifier.height(16.dp))
            CartButton(addToCart, modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PizzaOvenAppPreview() {
    PizzaOvenTheme {
        PizzaOvenAppContent(
            state = PizzaState(),
            updateCurrentPizza = {},
            updateSize = {},
            hasTopping = { false },
            addTopping = {},
            removeTopping = {},
            updatePrice = {},
            addToCart = {}
        )
    }
}