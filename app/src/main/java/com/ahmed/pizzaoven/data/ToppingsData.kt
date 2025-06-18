package com.ahmed.pizzaoven.data

import com.ahmed.pizzaoven.R

fun getToppingIcon(type: Toppings): Int {
    return when (type) {
        Toppings.ONION -> Onion.images[3]
        Toppings.BASIL -> Basil.images[3]
        Toppings.BROCCOLI -> Broccoli.images[3]
        Toppings.MUSHROOM -> Mushroom.images[3]
        Toppings.SAUSAGE -> Sausage.images[3]
        else -> 0
    }
}

fun getToppingImages(type: Toppings): List<Int> {
    return when (type) {
        Toppings.ONION -> Onion.images
        Toppings.BASIL -> Basil.images
        Toppings.BROCCOLI -> Broccoli.images
        Toppings.MUSHROOM -> Mushroom.images
        Toppings.SAUSAGE -> Sausage.images
        else -> emptyList()
    }
}

object Onion {
    val images = listOf(
        R.drawable.onion1,
        R.drawable.onion2,
        R.drawable.onion3,
        R.drawable.onion4,
        R.drawable.onion5,
        R.drawable.onion6,
        R.drawable.onion7,
        R.drawable.onion8,
        R.drawable.onion9,
        R.drawable.onion10
    )
}

object Basil {
    val images = listOf(
        R.drawable.basil1,
        R.drawable.basil2,
        R.drawable.basil3,
        R.drawable.basil4,
        R.drawable.basil5,
        R.drawable.basil6,
        R.drawable.basil7,
        R.drawable.basil8,
        R.drawable.basil9,
        R.drawable.basil10
    )
}

object Broccoli {
    val images = listOf(
        R.drawable.broccoli1,
        R.drawable.broccoli2,
        R.drawable.broccoli3,
        R.drawable.broccoli4,
        R.drawable.broccoli5,
        R.drawable.broccoli6,
        R.drawable.broccoli7,
        R.drawable.broccoli8,
        R.drawable.broccoli9,
        R.drawable.broccoli10
    )
}

object Mushroom {
    val images = listOf(
        R.drawable.mushroom1,
        R.drawable.mushroom2,
        R.drawable.mushroom3,
        R.drawable.mushroom4,
        R.drawable.mushroom5,
        R.drawable.mushroom6,
        R.drawable.mushroom7,
        R.drawable.mushroom8,
        R.drawable.mushroom9,
        R.drawable.mushroom10
    )
}

object Sausage {
    val images = listOf(
        R.drawable.sausage1,
        R.drawable.sausage2,
        R.drawable.sausage3,
        R.drawable.sausage4,
        R.drawable.sausage5,
        R.drawable.sausage6,
        R.drawable.sausage7,
        R.drawable.sausage8,
        R.drawable.sausage9,
        R.drawable.sausage10
    )
}
