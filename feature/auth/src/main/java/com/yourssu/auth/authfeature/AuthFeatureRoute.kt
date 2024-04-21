package com.yourssu.auth.authfeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun AuthFeatureRoute(
    coordinator: AuthFeatureCoordinator = rememberAuthFeatureCoordinator(),
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(AuthFeatureState())

    // UI Actions
    val actions = rememberAuthFeatureActions(coordinator)

    // UI Rendering
    AuthFeatureScreen(uiState, actions)
}


@Composable
fun rememberAuthFeatureActions(coordinator: AuthFeatureCoordinator): AuthFeatureActions {
    return remember(coordinator) {
        AuthFeatureActions(
            onClick = coordinator::doStuff
        )
    }
}