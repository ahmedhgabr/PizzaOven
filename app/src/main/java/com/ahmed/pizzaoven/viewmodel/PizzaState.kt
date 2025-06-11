package com.ahmed.pizzaoven.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.ahmed.pizzaoven.data.Toppings


data class PizzaState(
    val currentIndex: Int = 0,
    val pizzaList: SnapshotStateList<PizzaInfo> = mutableStateListOf(
        PizzaInfo(), PizzaInfo(), PizzaInfo(), PizzaInfo(), PizzaInfo(),
    )
)

data class PizzaInfo(
    val size: Int = 0,
    val toppings: List<Toppings> = emptyList(),
    val price: Int = 17
)