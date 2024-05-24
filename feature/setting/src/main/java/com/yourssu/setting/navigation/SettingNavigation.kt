package com.yourssu.setting.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.yourssu.setting.SettingScreen

const val SETTING_ROUTE = "setting"

fun NavController.navigateToSetting(navOptions: NavOptions) = navigate(SETTING_ROUTE, navOptions)

fun NavGraphBuilder.settingScreen(
) {
    composable(route = SETTING_ROUTE) {
        SettingScreen()
    }
}