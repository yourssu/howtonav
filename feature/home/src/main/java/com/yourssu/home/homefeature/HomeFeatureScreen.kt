package com.yourssu.home.homefeature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
fun TempHomeFeatureScreen(menu:String?, data:String?) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "TEMP HomeFeatureScreen")
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "data = $data")
        Text(text = "menu = $menu")
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

