package com.yourssu.drawer.drawerfeature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
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
    navigation(startDestination = "MATCH", route = "DRAWER") {
        composable("MATCH") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "MATCH")
            }
        }
        composable("IN_GAME") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "IN_GAME")
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