package com.yourssu.home.homefeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class HomeFeatureCoordinator(
    val viewModel: HomeFeatureViewModel,
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberHomeFeatureCoordinator(
    viewModel: HomeFeatureViewModel = hiltViewModel(),
): HomeFeatureCoordinator {
    return remember(viewModel) {
        HomeFeatureCoordinator(
            viewModel = viewModel
        )
    }
}