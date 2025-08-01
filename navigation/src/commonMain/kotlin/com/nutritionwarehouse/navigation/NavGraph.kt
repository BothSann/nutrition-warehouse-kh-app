package com.nutritionwarehouse.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nutritionwarehouse.auth.AuthScreen
import com.nutritionwarehouse.home.HomeGraphScreen
import com.nutritionwarehouse.profile.ProfileScreen
import com.nutritionwarehouse.shared.navigation.Screen


@Composable

fun SetupNavGraph (
    startDestination: Screen = Screen.Auth
)  {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Screen.Auth> {
            AuthScreen(
                navigateToHome = {
                    navController.navigate(Screen.HomeGraph) {
                        popUpTo<Screen.Auth> { inclusive = true }
                    }
                }
            )
        }

        composable<Screen.HomeGraph> {
            HomeGraphScreen(
                navigateToAuth = {
                    navController.navigate(Screen.Auth) {
                        popUpTo<Screen.HomeGraph> { inclusive = true }
                    }
                },
                navigateTProfile = {
                    navController.navigate(Screen.Profile)
                }
            )
        }
        composable<Screen.Profile> {
            ProfileScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}