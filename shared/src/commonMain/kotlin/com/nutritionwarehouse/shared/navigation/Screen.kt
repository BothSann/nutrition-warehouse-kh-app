package com.nutritionwarehouse.shared.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Auth : Screen()
    @Serializable
    data object HomeGraph : Screen()
    @Serializable
    data object ProductOverview : Screen()
    @Serializable
    data object Cart : Screen()
    @Serializable
    data object Categories : Screen()
    @Serializable
    data object Profile : Screen()

}