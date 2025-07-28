package com.nutritionwarehouse.home.domain

enum class CustomeDrawerState {
    Opened,
    Closed
}

fun CustomeDrawerState.isOpened(): Boolean {
    return this == CustomeDrawerState.Opened
}

fun CustomeDrawerState.opposite(): CustomeDrawerState {
    return if (this === CustomeDrawerState.Opened) {
        CustomeDrawerState.Closed
    } else {
        CustomeDrawerState.Opened
    }
}
