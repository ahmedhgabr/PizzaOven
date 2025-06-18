package com.ahmed.pizzaoven.composable

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmed.pizzaoven.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahmed.pizzaoven.data.Toppings
import com.ahmed.pizzaoven.viewmodel.PizzaInfo
import com.ahmed.pizzaoven.viewmodel.PizzaState
import com.ahmed.pizzaoven.viewmodel.PizzaViewModel

@Composable
fun PizzaDisplay(
//    breadImages: List<Int>,
    state: PizzaState,
    updateCurrPizza: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(270.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plate),
            contentDescription = "plate Image",
            modifier = Modifier.fillMaxWidth()
        )

        val breadImages = listOf(
            R.drawable.bread1,
            R.drawable.bread2,
            R.drawable.bread3,
            R.drawable.bread4,
            R.drawable.bread5
        )


        val offsetsX = List(5) { List(10) { (-70..70).random() } }
        val offsetsY = List(5) { List(10) { (-70..70).random() } }

        val pagerState = rememberPagerState(pageCount = {
            breadImages.size
        })

//            val page = pagerState.currentPage
        HorizontalPager(state = pagerState) { page ->
            updateCurrPizza(pagerState.currentPage)
            PizzaPage(
                state,
                breadImages = breadImages,
                page = page,
                offsetsX = offsetsX,
                offsetsY = offsetsY
            )
        }
    }


}


@Composable
fun PizzaPage(
    state: PizzaState,
    breadImages: List<Int>,
    offsetsX: List<List<Int>>,
    offsetsY: List<List<Int>>,
    page: Int
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = breadImages[page]),
            contentDescription = "bread Image",
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
                .height(300.dp)
                .padding(
                    horizontal = animateDpAsState(
                        targetValue = (35 - (state.pizzaList[state.currentIndex].size)).dp,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    ).value ,
                    vertical = animateDpAsState(
                        targetValue = (35 - (state.pizzaList[state.currentIndex].size)).dp,
                        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                    ).value
                )
        )

        state.pizzaList[state.currentIndex].toppings.forEach { topping ->

            val x = when (topping) {
                Toppings.ONION -> 1
                Toppings.BASIL -> 2
                Toppings.BROCCOLI -> 3
                Toppings.MUSHROOM -> 4
                Toppings.SAUSAGE -> 0
            }
            ToppingsDisplay(
                state = state,
                topping,
                offsetsX[x],
                offsetsY[x],
                modifier = Modifier
            )
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun PizzaDisplayPreview() {
//    val one = PizzaInfo(
//        size = 10,
//        price = 100,
//        toppings = listOf(Toppings.ONION, Toppings.BROCCOLI, Toppings.MUSHROOM)
//    )
//    PizzaDisplay(
//        state = PizzaState(
//            pizzaList = mutableListOf(one, one, one, one, one),
//            currentIndex = 0
//        ),
//        updateCurrPizza = {},
//        modifier = Modifier
//    )
//}