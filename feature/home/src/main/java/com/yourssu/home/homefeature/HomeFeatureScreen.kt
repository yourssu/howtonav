package com.yourssu.home.homefeature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeFeatureScreen(
    state: HomeFeatureState,
    actions: HomeFeatureActions,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "HomeFeatureScreen")
    }
}

@Composable
fun TempHomeFeatureScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "TEMP HomeFeatureScreen")
    }
}

@Composable
@Preview(name = "HomeFeature")
private fun HomeFeatureScreenPreview() {
    HomeFeatureScreen(
        state = HomeFeatureState(),
        actions = HomeFeatureActions()
    )
}

