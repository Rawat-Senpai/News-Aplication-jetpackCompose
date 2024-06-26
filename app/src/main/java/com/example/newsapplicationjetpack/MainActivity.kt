package com.example.newsapplicationjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapplicationjetpack.presentation.navgraph.NavGraph
import com.example.newsapplicationjetpack.screens.HomeScreen
import com.example.newsapplicationjetpack.screens.ScienceScreen
import com.example.newsapplicationjetpack.screens.SportsScreen
import com.example.newsapplicationjetpack.ui.theme.NewsApplicationJetpackTheme
import com.example.newsapplicationjetpack.utils.Screens
import com.example.newsapplicationjetpack.viewModels.MainViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }



        setContent {
            NewsApplicationJetpackTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }



                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }

        }
    }
}

@Composable
fun MyBottomAppBar() {

    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(bottomBar = {
        BottomAppBar(containerColor = Color.Green) {
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }

                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                )
            }

            IconButton(
                onClick = {
                    selected.value = Icons.Default.ShoppingCart
                    navigationController.navigate(Screens.Science.screen) {
                        popUpTo(0)
                    }

                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (selected.value == Icons.Default.ShoppingCart) Color.White else Color.DarkGray
                )
            }

            IconButton(
                onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(Screens.Sports.screen) {
                        popUpTo(0)
                    }

                },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                )
            }
        }
    }) {
        paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screen ,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Home.screen){ HomeScreen()}
            composable(Screens.Science.screen){ ScienceScreen() }
            composable(Screens.Sports.screen){ SportsScreen() }
        }
    }


}


/*
    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                item.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                        },
                                        label = {
                                                Text(text = item.title)
                                        },
                                        icon = {
                                            BadgedBox(
                                                badge = {

                                                }
                                            ) {
                                                androidx.compose.material3.Icon(
                                                    imageVector = if (index == selectedItemIndex) {
                                                        item.selected
                                                    } else item.unselectedIcon,
                                                    contentDescription = item.title
                                                )
                                            }
                                        })
                                }
                            }
                        }
                    ) {

                    }
 */

