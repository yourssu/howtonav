package com.yourssu.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = "",
) {
    AUTH(
        "AUTH",
        Icons.Filled.AccountCircle,
        "AUTH"
    ),
    HOME(
        "HOME",
        Icons.Filled.Home,
        "HOME"
    ),
    DRAWER(
        "DRAWER",
        Icons.Filled.Favorite,
        "DRAWER"
    );
}
