package com.example.newsapplicationjetpack.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val screen:String) {
    data object Home : Screens("home")
    data object Science  : Screens("science")
    data object Sports : Screens("sports")
}