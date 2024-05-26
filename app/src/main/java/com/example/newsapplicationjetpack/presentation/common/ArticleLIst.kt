package com.example.newsapplicationjetpack.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.presentation.Dimens

@Composable
fun ArticleList(
    modifier:Modifier = Modifier,
    articles:LazyPagingItems<Article>,
    onClick:(Article) -> Unit
){
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            contentPadding =  PaddingValues(all= Dimens.ExtraSmallPadding2)
        ) {
            items(count = articles.itemCount){
                articles[it]?.let {
                    ArticleCard(modifier=Modifier , article = it, onClick= { onClick(it) } )
                }
            }


        }
    }

}

@Composable
fun handlePagingResult(
    articles:LazyPagingItems<Article>
):Boolean{

    val loadingState = articles.loadState
    var error = when{
        loadingState.refresh is LoadState.Error-> loadingState.refresh as LoadState.Error
        loadingState.prepend is LoadState.Error-> loadingState.prepend as LoadState.Error
        loadingState.append is LoadState.Error -> loadingState.append as LoadState.Error

        else -> null
    }

    return when{
        loadingState.refresh is LoadState.Loading->{
                ShimmerEffect()
            false
        }
        error != null->{
            EmptyScreen()
            false

        }
        else ->{
            true
        }
    }


}


@Composable
private fun ShimmerEffect(){
    Column (verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding1)
            )
        }

    }
}