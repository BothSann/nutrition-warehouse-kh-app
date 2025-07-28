package com.nutritionwarehouse.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import com.nutritionwarehouse.home.component.BottomBar
import com.nutritionwarehouse.home.domain.BottomBarDestination
import com.nutritionwarehouse.shared.BebaNeueFont
import com.nutritionwarehouse.shared.FontSize
import com.nutritionwarehouse.shared.IconPrimary
import com.nutritionwarehouse.shared.Resources
import com.nutritionwarehouse.shared.Surface
import com.nutritionwarehouse.shared.TextPrimary
import com.nutritionwarehouse.shared.navigation.Screen
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeGraphScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState()
    val selectedDestination by remember {
        derivedStateOf {
            val route = currentRoute.value?.destination?.route.toString()
            when {
                route.contains(Screen.ProductOverview.toString()) -> BottomBarDestination.ProductsOverview
                route.contains(Screen.Cart.toString()) -> BottomBarDestination.Cart
                route.contains(Screen.Categories.toString()) -> BottomBarDestination.Categories
                else -> BottomBarDestination.ProductsOverview
            }
        }
    }


    Scaffold(
        containerColor = Surface,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    AnimatedContent (
                        targetState = selectedDestination
                    ){ destination ->
                        Text(
                            text = destination.title,
                            fontFamily = BebaNeueFont(),
                            fontSize = FontSize.LARGE,
                            color = TextPrimary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(Resources.Icon.Menu),
                            contentDescription = "Menu Icon",
                            tint = IconPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Surface,
                    scrolledContainerColor = Surface,
                    titleContentColor = TextPrimary,
                    navigationIconContentColor = IconPrimary,
                    actionIconContentColor = IconPrimary
                )
            )
        },
    ) { padding->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
        ) {
            NavHost(
                modifier = Modifier
                    .weight(1f),
                navController = navController,
                startDestination = Screen.ProductOverview,
            ) {
                composable <Screen.ProductOverview> {  }
                composable <Screen.Cart> {  }
                composable <Screen.Categories> {  }

            }
            Spacer(modifier = Modifier
                .height(12.dp))
            Box(
                modifier = Modifier
                    .padding(all = 12.dp)
            ) {
                BottomBar(
                    selected = selectedDestination,
                    onSelect = { destination ->
                        navController.navigate(destination.screen) {
                            launchSingleTop = true
                            popUpTo<Screen.ProductOverview> {
                                saveState = true
                                inclusive = false
                            }
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}