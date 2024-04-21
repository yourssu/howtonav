package com.yourssu.drawer.drawerfeature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents DrawerFeatureScreen
 **/
class DrawerFeatureState

/**
 * DrawerFeature Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class DrawerFeatureActions(
    val onClick: () -> Unit = {},
)