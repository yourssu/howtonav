package com.yourssu.auth.authfeature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

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
fun TempAuthFeatureScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TEMP AuthFeatureScreen")
        Button(onClick = {
            navController.navigate("HOME/9876") {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Go to HOME")
        }
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

