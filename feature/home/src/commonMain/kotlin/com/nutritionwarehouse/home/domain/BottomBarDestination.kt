package com.nutritionwarehouse.home.domain

import com.nutritionwarehouse.shared.Resources
import com.nutritionwarehouse.shared.navigation.Screen
import org.jetbrains.compose.resources.DrawableResource

enum class BottomBarDestination(
    val icon: DrawableResource,
    val title: String,
    val screen: Screen
) {
    ProductsOverview(
        icon = Resources.Icon.Home,
        title = "Nutri Warehouse",
        screen = Screen.ProductOverview
    ),
    Cart(
    icon = Resources.Icon.ShoppingCart,
    title = "Cart",
    screen = Screen.Cart
    ),
    Categories(
    icon = Resources.Icon.Categories,
    title = "Categories",
    screen = Screen.Categories
    )
}