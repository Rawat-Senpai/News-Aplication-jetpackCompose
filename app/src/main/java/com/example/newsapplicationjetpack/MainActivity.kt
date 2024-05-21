package com.example.newsapplicationjetpack

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapplicationjetpack.api.NewsApi
import com.example.newsapplicationjetpack.screens.BottomNavigationItem
import com.example.newsapplicationjetpack.ui.theme.NewsApplicationJetpackTheme
import com.example.newsapplicationjetpack.utils.BottomNavItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsApi: NewsApi

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            var response = newsApi.getNewsHeadlines("1f2e109c082d4ee4b2ad94f523c1f220", "business")

            Log.d("CheckingTag", response.body().toString())
        }

        setContent {

            val item = listOf(
                BottomNavigationItem(
                    title = "General",
                    selected = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home
                ), BottomNavigationItem(
                    title = "Sports",
                    selected = Icons.Filled.ShoppingCart,
                    unselectedIcon = Icons.Outlined.ShoppingCart
                ), BottomNavigationItem(
                    title = "Setting",
                    selected = Icons.Filled.Settings,
                    unselectedIcon = Icons.Outlined.Settings
                )
            )


            NewsApplicationJetpackTheme {
                // A surface container using the 'background' color from the theme
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
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


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsApplicationJetpackTheme {
        Greeting("Android")
    }
}