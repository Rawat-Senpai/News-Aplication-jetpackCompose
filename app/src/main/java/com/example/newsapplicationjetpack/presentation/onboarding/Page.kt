package com.example.newsapplicationjetpack.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapplicationjetpack.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

val pages = listOf(
    Page(
        title = "Lorem Ipsum is simple dummy",
        description = "Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is simple dummy",
        description = "Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem Ipsum is simple dummy",
        description = "Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy Lorem Ipsum is simple dummy",
        image = R.drawable.onboarding1
    )
)

