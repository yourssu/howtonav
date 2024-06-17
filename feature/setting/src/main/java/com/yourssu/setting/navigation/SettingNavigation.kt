package com.yourssu.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.yourssu.setting.SettingScreen

const val SETTING_ROUTE = "setting"

private const val DEEP_LINK_URI_PATTERN = "rally://howtonav.com/setting"

fun NavController.navigateToSetting(navOptions: NavOptions) = navigate(SETTING_ROUTE, navOptions)

fun NavGraphBuilder.settingScreen(
) {
    composable(
        route = SETTING_ROUTE,
        deepLinks = listOf(navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN })
    ) {
        SettingScreen()
    }
}