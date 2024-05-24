package com.yourssu.howtonav.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.yourssu.design.system.compose.component.BottomBar
import com.yourssu.design.system.compose.component.BottomBarItem
import com.yourssu.drawer.navigation.DRAWER_ROUTE
import com.yourssu.drawer.navigation.navigateToDrawer
import com.yourssu.home.navigation.HOME_ROUTE
import com.yourssu.home.navigation.navigateToHome
import com.yourssu.howtonav.R
import com.yourssu.howtonav.navigation.HtnNavHost
import com.yourssu.setting.navigation.SETTING_ROUTE
import com.yourssu.setting.navigation.navigateToSetting

@Composable
fun HowtonavApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar {
                val topLevelNavOptions = navOptions {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items

                    // TODO : Below Code Doesn't work
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true
//                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }

                BottomBarItem(
                    selected = navController.currentDestination?.route == HOME_ROUTE,
                    onClick = { navController.navigateToHome(topLevelNavOptions) },
                    selectedIcon = R.drawable.ic_home,
                    unselectedIcon = R.drawable.ic_home,
                )

                BottomBarItem(
                    selected = navController.currentDestination?.route == DRAWER_ROUTE,
                    onClick = {
                        navController.navigateToDrawer(
                            id = "Yourssu",
                            navOptions = topLevelNavOptions
                        )
                    },
                    selectedIcon = R.drawable.ic_drawer,
                    unselectedIcon = R.drawable.ic_drawer,
                )

                BottomBarItem(
                    selected = navController.currentDestination?.route == SETTING_ROUTE,
                    onClick = { navController.navigateToSetting(topLevelNavOptions) },
                    selectedIcon = R.drawable.ic_setting,
                    unselectedIcon = R.drawable.ic_setting,
                )
            }
        }
    ) { padding ->
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            HtnNavHost(
                navController = navController
            )
        }
    }
}