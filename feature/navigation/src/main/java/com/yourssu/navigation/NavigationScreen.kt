package com.yourssu.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yourssu.auth.authfeature.TempAuthFeatureScreen
import com.yourssu.drawer.drawerfeature.TempDrawerFeatureScreen
import com.yourssu.home.homefeature.TempHomeFeatureScreen

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()

    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems()
                    .forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = index == navigationSelectedItem,
                            label = { Text(item.label) },
                            icon = { Icon(item.icon, null) },
                            onClick = {
                                navigationSelectedItem = index
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "AUTH",
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable("AUTH") {
                TempAuthFeatureScreen()
            }
            composable("HOME") {
                TempHomeFeatureScreen()
            }
            composable("DRAWER") {
                TempDrawerFeatureScreen()
            }
        }
    }
}

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = "",
) {

    //function to get the list of bottomNavigationItems
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "AUTH",
                icon = Icons.Filled.AccountCircle,
                route = "AUTH"
            ),
            BottomNavigationItem(
                label = "HOME",
                icon = Icons.Filled.Home,
                route = "HOME"
            ),
            BottomNavigationItem(
                label = "DRAWER",
                icon = Icons.Filled.Favorite,
                route = "DRAWER"
            ),
        )
    }
}