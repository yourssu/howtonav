package com.yourssu.auth.authfeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class AuthFeatureCoordinator(
    val viewModel: AuthFeatureViewModel,
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberAuthFeatureCoordinator(
    viewModel: AuthFeatureViewModel = hiltViewModel(),
): AuthFeatureCoordinator {
    return remember(viewModel) {
        AuthFeatureCoordinator(
            viewModel = viewModel
        )
    }
}