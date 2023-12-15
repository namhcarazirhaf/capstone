package com.belajar.capstoneapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val desc: String,
    val icon: ImageVector,
    val screen: Screen
)