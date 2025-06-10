package com.ahmed.pizzaoven.viewmodel

import com.ahmed.pizzaoven.data.Toppings


//data class PizzaState(
//    val currentIndex: Int = 0,
//    val pizzaList: MutableList<PizzaInfo> = MutableList(5) { PizzaInfo() },
//)

data class PizzaState(
    val size: Int = 0,
    val toppings: List<Toppings> = emptyList(),
    val price: Int = 17
)