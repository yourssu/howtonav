package com.yourssu.auth.authfeature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthFeatureScreen(
    state: AuthFeatureState,
    actions: AuthFeatureActions,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "AuthFeatureScreen")
    }
}

@Composable
fun TempAuthFeatureScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "TEMP AuthFeatureScreen")
    }
}

@Composable
@Preview(name = "AuthFeature")
private fun AuthFeatureScreenPreview() {
    AuthFeatureScreen(
        state = AuthFeatureState(),
        actions = AuthFeatureActions()
    )
}

