package com.example.newsapplicationjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search

import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapplicationjetpack.api.NewsApi
import com.example.newsapplicationjetpack.domain.userCases.AppEntryUseCases
import com.example.newsapplicationjetpack.presentation.onboarding.OnBoardingScreen
import com.example.newsapplicationjetpack.presentation.onboarding.OnBoardingViewModel
import com.example.newsapplicationjetpack.screens.HomeScreen
import com.example.newsapplicationjetpack.screens.ScienceScreen
import com.example.newsapplicationjetpack.screens.SportsScreen
import com.example.newsapplicationjetpack.ui.theme.NewsApplicationJetpackTheme
import com.example.newsapplicationjetpack.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsApi: NewsApi

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GlobalScope.launch {
//            var response = newsApi.getNewsHeadlines("1f2e109c082d4ee4b2ad94f523c1f220", "business")
//            Log.d("CheckingTag", response.body().toString())
//        }
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
               Log.d("CheckingData",it.toString())
            }
        }


        setContent {
            NewsApplicationJetpackTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val viewModel :OnBoardingViewModel = hiltViewModel()

                    OnBoardingScreen(
                        events = viewModel::onEvent
                    )
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

