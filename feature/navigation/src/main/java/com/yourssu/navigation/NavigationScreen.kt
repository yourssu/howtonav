package com.yourssu.navigation

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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

    val firstPath = intent?.data?.path?.split("/")?.get(1)
    Log.d("NavigationScreen", "firstPath: $firstPath")

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

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
                BottomNavigationItem.entries.toList().forEach { item ->
                    NavigationBarItem(
                        selected = item.route == currentRoute,
                        label = { Text(item.label) },
                        icon = { Icon(item.icon, null) },
                        onClick = {
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
            startDestination = firstPath?.uppercase() ?: "AUTH",
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(
                "AUTH",
                deepLinks = listOf(navDeepLink {
                    uriPattern = "https://howtonav.com/auth"
                })
            ) {
                TempAuthFeatureScreen()
            }
            composable(
                "HOME",
                deepLinks = listOf(navDeepLink {
                    uriPattern = "https://howtonav.com/home{menu}"
                }),
                arguments = listOf(navArgument("data") {
                    type = NavType.StringType
                    defaultValue = "DEFAULT_VALUE"
                })
            ) {
                val data = it.arguments?.getString("data")
                val menu = it.arguments?.getString("menu")
                TempHomeFeatureScreen(menu ?: "null")
            }
            addDrawerFeatureRoute(navController = navController)
        }
    }
}