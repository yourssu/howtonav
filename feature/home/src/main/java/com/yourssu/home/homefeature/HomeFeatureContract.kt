package com.yourssu.home.homefeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents HomeFeatureScreen
 **/
class HomeFeatureState

/**
 * HomeFeature Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class HomeFeatureActions(
    val onClick: () -> Unit = {},
)