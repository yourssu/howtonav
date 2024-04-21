package com.yourssu.auth.authfeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents AuthFeatureScreen
 **/
class AuthFeatureState

/**
 * AuthFeature Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class AuthFeatureActions(
    val onClick: () -> Unit = {},
)