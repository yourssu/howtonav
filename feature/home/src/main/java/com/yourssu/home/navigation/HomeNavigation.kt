package com.yourssu.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.yourssu.home.HomeScreen

const val HOME_ROUTE = "home"
private const val DEEP_LINK_URI_PATTERN = "rally://howtonav.com/home"

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen(
    onDrawerClick: (id: Long) -> Unit,
    onSettingClick: () -> Unit,
) {
    composable(
        route = HOME_ROUTE,
        deepLinks = listOf(navDeepLink {
            uriPattern = DEEP_LINK_URI_PATTERN
        })
    ) {
        HomeScreen(
            onDrawerClick = onDrawerClick,
            onSettingClick = onSettingClick,
        )
    }
}