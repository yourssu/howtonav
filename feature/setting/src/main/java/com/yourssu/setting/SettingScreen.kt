package com.yourssu.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Setting")
    }
}

@Preview
@Composable
private fun SettingScreenPreview() {
    SettingScreen()
}