package com.ahmed.pizzaoven.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.pizzaoven.data.Toppings
import com.ahmed.pizzaoven.data.getToppingImages
import com.ahmed.pizzaoven.viewmodel.PizzaState

@Composable
fun ToppingsDisplay(
    state: PizzaState,
    type: Toppings,
    offsetsX: List<Int>,
    offsetsY: List<Int>,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val toppingAnimatedSize = remember { Animatable(with(density) { 200.dp.toPx() }) }

    LaunchedEffect(
        Unit
    ) {
        toppingAnimatedSize.animateTo(
            targetValue = with(density) { 30.dp.toPx() }
        )

    }
    Box(
        modifier = modifier
    ) {
        val toppingImages = getToppingImages(type)
        for (i in 0..9) {
            Image(
                painter = painterResource(id = toppingImages[i]),
                contentDescription = "Topping Image",
                modifier = Modifier
                    .size(
                        animateDpAsState(
                        targetValue = with(density) { toppingAnimatedSize.value.toDp() } +(10 + (state.pizzaList[state.currentIndex].size)).dp,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    ).value)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .offset(x = offsetsX[i].dp, y = offsetsY[i].dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ToppingsDisplayPreview() {
    ToppingsDisplay(
        state = PizzaState(),
        Toppings.ONION,
        List(10) { (-70..70).random() },
        List(10) { (-70..70).random() }
    )
}



