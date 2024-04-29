package com.yourssu.auth.authfeature

import androidx.compose.foundation.layout.Arrangement
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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

