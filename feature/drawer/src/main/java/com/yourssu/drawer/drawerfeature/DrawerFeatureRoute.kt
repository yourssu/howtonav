package com.yourssu.drawer.drawerfeature

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation

@Composable
fun DrawerFeatureRoute(
    coordinator: DrawerFeatureCoordinator = rememberDrawerFeatureCoordinator(),
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(DrawerFeatureState())

    // UI Actions
    val actions = rememberDrawerFeatureActions(coordinator)

    // UI Rendering
    DrawerFeatureScreen(uiState, actions)
}


fun NavGraphBuilder.addDrawerFeatureRoute(navController: NavController) {
    navigation(startDestination = "MAIN", route = "DRAWER") {
        composable("MAIN", deepLinks = listOf(navDeepLink {
            uriPattern = "https://howtonav.com/drawer/main"
        })) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "MAIN")
                Button(onClick = {
                    navController.navigate("PRODUCT/1234") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Go to PRODUCT")
                }
            }
        }
        composable(
            route = "PRODUCT/{id}",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://howtonav.com/drawer/product/{id}"
                })
        ) {
            val id = it.arguments?.getString("id")

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "PRODUCT_ID $id")
                Button(onClick = {
                    navController.navigate("MAIN") {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }) {
                    Text(text = "Go to MAIN")
                }
            }
        }
    }
}


@Composable
fun rememberDrawerFeatureActions(coordinator: DrawerFeatureCoordinator): DrawerFeatureActions {
    return remember(coordinator) {
        DrawerFeatureActions(
            onClick = coordinator::doStuff
        )
    }
}