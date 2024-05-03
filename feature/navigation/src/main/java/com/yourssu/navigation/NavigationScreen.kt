package com.yourssu.navigation

import android.app.Activity
import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import androidx.navigation.NavType
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.yourssu.auth.authfeature.TempAuthFeatureScreen
import com.yourssu.drawer.drawerfeature.addDrawerFeatureRoute
import com.yourssu.home.homefeature.TempHomeFeatureScreen

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val activity = context as? Activity
    val intent = activity?.intent

    intent.let {
        Log.d("NavigationScreen", "data: ${it?.data}")
        Log.d("NavigationScreen", "host : ${it?.data?.host}")
        Log.d("NavigationScreen", "isHierarchical : ${it?.data?.isHierarchical}")
        Log.d("NavigationScreen", "query : ${it?.data?.query}")
        Log.d("NavigationScreen", "path : ${it?.data?.path}")
        Log.d("NavigationScreen", "scheme : ${it?.data?.scheme}")
        Log.d("NavigationScreen", "pathSegments : ${it?.data?.pathSegments}")
    }

    val firstPath = intent?.data?.pathSegments?.first()
    Log.d("NavigationScreen", "firstPath: $firstPath")

    var navigationSelectedItem by remember {
        mutableIntStateOf(
            when (firstPath) {
                "auth" -> 0
                "home" -> 1
                "drawer" -> 2
                else -> 0
            }
        )
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
                                    popUpTo(navController.graph.id) {
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
            startDestination = "HOME/{data}",
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(
                "AUTH",
                deepLinks = listOf(navDeepLink {
                    uriPattern = "https://howtonav.com/auth"
                })
            ) {
                TempAuthFeatureScreen(navController = navController)
            }
            composable(
                "HOME/{data}",
                deepLinks = listOf(navDeepLink {
                    uriPattern = "https://howtonav.com/home/{menu}"
                }),
                arguments = listOf(navArgument("data") {
                    type = NavType.StringType
                    defaultValue = "DEFAULT_VALUE"
                })
            ) {
                val data = it.arguments?.getString("data")
                val menu = it.arguments?.getString("menu")
                TempHomeFeatureScreen(menu, data)
            }
            addDrawerFeatureRoute(navController = navController)
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
                route = "HOME/{data}"
            ),
            BottomNavigationItem(
                label = "DRAWER",
                icon = Icons.Filled.Favorite,
                route = "DRAWER"
            ),
        )
    }
}