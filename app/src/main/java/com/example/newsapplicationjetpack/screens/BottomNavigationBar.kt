package com.example.newsapplicationjetpack.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

data class BottomNavigationItem(
    val title:String,
    val selected:ImageVector,
    val unselectedIcon:ImageVector,

)