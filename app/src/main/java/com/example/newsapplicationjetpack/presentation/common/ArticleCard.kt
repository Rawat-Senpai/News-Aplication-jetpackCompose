package com.example.newsapplicationjetpack.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapplicationjetpack.R
import com.example.newsapplicationjetpack.domain.models.Article
import com.example.newsapplicationjetpack.presentation.Dimens.ArticleSize
import com.example.newsapplicationjetpack.presentation.Dimens.ExtraSmallPadding
import com.example.newsapplicationjetpack.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapplicationjetpack.presentation.Dimens.SmallIconSize
import com.example.newsapplicationjetpack.ui.theme.NewsApplicationJetpackTheme


@Composable
fun ArticleCard(
    modifier: Modifier,
    article: Article,
    onClick: () -> Unit,
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .size(ArticleSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleSize)
        ) {

            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row (verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = article.author,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null ,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

            }


        }
    }

}


@Preview(showBackground = true)
@Composable
fun ArticleCardPreview() {
    NewsApplicationJetpackTheme {
        ArticleCard(
            modifier = Modifier, article = Article(
                author = "Rawat Senpai",
                content = "",
                description = "",
                publishedAt = "11/12/2024",
                title = "Her transi broke donw her phonse",
                url = "",
                urlToImage = ""
            )
        ) {

        }
    }
}
