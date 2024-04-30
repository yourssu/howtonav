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
        NavigationRoute.AUTH,
        Icons.Filled.AccountCircle,
        NavigationRoute.AUTH
    ),
    HOME(
       "HOME",
        Icons.Filled.Home,
        NavigationRoute.HOME
    ),
    DRAWER(
        NavigationRoute.DRAWER,
        Icons.Filled.Favorite,
        NavigationRoute.DRAWER
    );
}
