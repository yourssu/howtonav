package com.yourssu.drawer.drawerfeature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawerFeatureScreen(
    state: DrawerFeatureState,
    actions: DrawerFeatureActions,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "DrawerFeatureScreen")
    }
}

@Composable
fun TempDrawerFeatureScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "TEMP DrawerFeatureScreen")
    }
}

@Composable
@Preview(name = "DrawerFeature")
private fun DrawerFeatureScreenPreview() {
    DrawerFeatureScreen(
        state = DrawerFeatureState(),
        actions = DrawerFeatureActions()
    )
}

