package com.example.newsapplicationjetpack.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.newsapplicationjetpack.R
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.presentation.Dimens
import com.example.newsapplicationjetpack.presentation.common.ArticleList
import com.example.newsapplicationjetpack.presentation.common.SearchBar
import com.example.newsapplicationjetpack.presentation.navgraph.Route


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(articles: LazyPagingItems<Article>, navigate: (String) -> Unit) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo), contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimens.MediumPadding1)
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

//        SearchBar(text = "",
//            readOnly = true,
//            onValueChange = {},
//
//            onSearch = {}
//        )
        
        Spacer(modifier = Modifier.height(Dimens.MediumPadding2))
        
        Text(text = titles,
            Modifier
                .fillMaxWidth()
                .padding(start = Dimens.MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp)

        Spacer(modifier = Modifier.height(Dimens.MediumPadding2))
        
        ArticleList(articles = articles,
            modifier = Modifier.padding(Dimens.MediumPadding1),
            onClick = {
                navigate(Route.DetailsScreen.route)
            }
        )
    }


}