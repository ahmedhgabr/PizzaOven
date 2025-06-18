package com.ahmed.pizzaoven.viewmodel

import androidx.lifecycle.ViewModel
import com.ahmed.pizzaoven.data.Toppings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class PizzaViewModel : ViewModel() {
    private val _pizzaState = MutableStateFlow(PizzaState())
    val pizzaState = _pizzaState.asStateFlow()

    fun updateCurrentIndex(index: Int) {
        _pizzaState.value = _pizzaState.value.copy(currentIndex = index)
    }

    fun updateSize(size: Int) {
        val index = _pizzaState.value.currentIndex
        val newPizza = _pizzaState.value.pizzaList[index].copy(size = size)
        _pizzaState.update { it.copy(
            pizzaList = _pizzaState.value.pizzaList.apply {
                this[index] = newPizza
            }
        )}
        println(_pizzaState.value)
    }


    fun hasTopping(topping: Toppings): Boolean {
        val index = _pizzaState.value.currentIndex
        println("$index is Selected" + _pizzaState.value.pizzaList[index].toppings.contains(topping))
        return _pizzaState.value.pizzaList[index].toppings.contains(topping)
    }

    fun addTopping(topping: Toppings) {
        val index = _pizzaState.value.currentIndex
        _pizzaState.value = _pizzaState.value.copy(
            pizzaList = _pizzaState.value.pizzaList.apply {
                this[index] = this[index].copy(
                    toppings = this[index].toppings + topping
                )
            }
        )
    }

    fun removeTopping(topping: Toppings) {
        val index = _pizzaState.value.currentIndex
        _pizzaState.value = _pizzaState.value.copy(
            pizzaList = _pizzaState.value.pizzaList.apply {
                this[index] = this[index].copy(
                    toppings = this[index].toppings - topping
                )
            }
        )
    }

    fun updatePrice(price: Int) {
        val index = _pizzaState.value.currentIndex
        _pizzaState.value = _pizzaState.value.copy(
            pizzaList = _pizzaState.value.pizzaList.apply {
                this[index] = this[index].copy(price = price)
            }
        )
    }

    fun resetPizza() {
        val index = _pizzaState.value.currentIndex
        _pizzaState.value.pizzaList[index] = PizzaInfo()
    }

    fun addToCart() {
        val index = _pizzaState.value.currentIndex
        // Logic to save the order can be implemented here
    }

}