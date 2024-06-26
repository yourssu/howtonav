package com.yourssu.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Content() {
    Text("ComposableFragment")
}

@Composable
fun HomeScreen(
    onDrawerClick: (id: Long) -> Unit,
    onSettingClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Hello Home!", fontSize = 24.sp)
        Button(
            onClick = { onDrawerClick(123) }
        ) {
            Text("To Drawer")
        }
        Button(
            onClick = onSettingClick
        ) {
            Text("To Setting")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

}