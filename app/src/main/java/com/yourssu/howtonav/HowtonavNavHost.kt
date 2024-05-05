package com.yourssu.howtonav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.yourssu.drawer.navigation.drawerScreen
import com.yourssu.drawer.navigation.navigateDrawer
import com.yourssu.home.navigation.HOME_ROUTE
import com.yourssu.home.navigation.homeScreen

@Composable
fun HowtonavNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(
            onDrawerClick = navController::navigateDrawer,
            onSettingClick = {
                navController.navigate("setting")
            }
        )
        drawerScreen()
    }
}