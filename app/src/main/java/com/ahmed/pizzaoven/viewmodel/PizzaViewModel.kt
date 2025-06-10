package com.ahmed.pizzaoven.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmed.pizzaoven.data.Toppings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PizzaViewModel : ViewModel() {
    private val _pizzaState = MutableStateFlow(PizzaState())
    val pizzaState = _pizzaState.asStateFlow()

    fun updateCurrentIndex(index: Int) {
//        _pizzaState.value = _pizzaState.value.copy(currentIndex = index)
    }

    fun updateSize(size: Int) {
        _pizzaState.value = _pizzaState.value.copy(size = size)
    }


    fun hasTopping(topping: Toppings): Boolean {
        return _pizzaState.value.toppings.contains(topping)
    }

    fun addTopping(topping: Toppings) {
        _pizzaState.value = _pizzaState.value.copy(toppings = _pizzaState.value.toppings + topping)
    }

    fun removeTopping(topping: Toppings) {
        _pizzaState.value = _pizzaState.value.copy(toppings = _pizzaState.value.toppings - topping)
    }

    fun updatePrice(price: Int) {
        _pizzaState.value = _pizzaState.value.copy(price = price)
    }

    fun resetPizza() {
        _pizzaState.value = PizzaState()
    }

    fun addToCart() {
        // Logic to save the order can be implemented here
    }

}