package com.yourssu.drawer.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.yourssu.drawer.DrawerScreen

const val DRAWER_PROD_ID_ARG = "id"
const val DRAWER_ROUTE_BASE = "drawer"
const val DRAWER_ROUTE = "drawer/{$DRAWER_PROD_ID_ARG}"
private const val DEEPLINK_URI_PATTERN = "https://howtonav.com/drawer/{$DRAWER_PROD_ID_ARG}"

fun NavController.navigateDrawer(id: String) = navigate("$DRAWER_ROUTE_BASE/$id")

fun NavGraphBuilder.drawerScreen() {
    composable(
        route = DRAWER_ROUTE,
        deepLinks = listOf(navDeepLink { uriPattern = DEEPLINK_URI_PATTERN }),
        arguments = listOf(
            navArgument(DRAWER_PROD_ID_ARG) {
                type = NavType.StringType
                defaultValue = "DEFAULT_VALUE"
            }
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getString(DRAWER_PROD_ID_ARG) ?: "0"
        DrawerScreen(id)
    }
}
