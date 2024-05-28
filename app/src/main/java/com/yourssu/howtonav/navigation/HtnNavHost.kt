package com.yourssu.howtonav.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.yourssu.drawer.navigation.drawerScreen
import com.yourssu.home.navigation.HOME_ROUTE
import com.yourssu.home.navigation.homeScreen
import com.yourssu.setting.navigation.settingScreen

@Composable
fun HtnNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = HOME_ROUTE, modifier = modifier) {
        homeScreen(onDrawerClick = {}, onSettingClick = {})
        drawerScreen()
        settingScreen()
    }
}
