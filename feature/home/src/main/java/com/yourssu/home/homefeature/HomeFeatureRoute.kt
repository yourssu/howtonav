package com.yourssu.home.homefeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun HomeFeatureRoute(
    coordinator: HomeFeatureCoordinator = rememberHomeFeatureCoordinator(),
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(HomeFeatureState())

    // UI Actions
    val actions = rememberHomeFeatureActions(coordinator)

    // UI Rendering
    HomeFeatureScreen(uiState, actions)
}


@Composable
fun rememberHomeFeatureActions(coordinator: HomeFeatureCoordinator): HomeFeatureActions {
    return remember(coordinator) {
        HomeFeatureActions(
            onClick = coordinator::doStuff
        )
    }
}