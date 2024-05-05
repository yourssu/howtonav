package com.yourssu.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yourssu.home.HomeScreen

const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(
    onDrawerClick: (id: Long) -> Unit,
    onSettingClick: () -> Unit,
) {
    composable(HOME_ROUTE) {
        HomeScreen(
            onDrawerClick = onDrawerClick,
            onSettingClick = onSettingClick,
        )
    }
}