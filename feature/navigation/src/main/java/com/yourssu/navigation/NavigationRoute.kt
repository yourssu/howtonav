package com.yourssu.navigation

object NavigationRoute {
    const val AUTH = "AUTH"
    const val HOME = "HOME/${Type.DATA}"
    const val DRAWER = "DRAWER"
}

object Type {
    const val DATA = "data"
    const val MENU = "menu"
}