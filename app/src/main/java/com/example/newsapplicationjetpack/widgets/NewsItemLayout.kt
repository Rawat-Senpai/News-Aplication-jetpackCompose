package com.example.newsapplicationjetpack.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Preview
@Composable
fun PreviewFunc(){
    NewsItemLayout()
}


@Composable
fun NewsItemLayout(){

    Column {
        Box(modifier = Modifier
            .height(200.dp)
            .width(200.dp),
            contentAlignment = Alignment.TopCenter
         ){
            val painter = rememberAsyncImagePainter(model = "https://res.infoq.com/articles/llm-productivity-experiment/en/headerimage/generatedHeaderImage-1715933929540.jpg")
            Image(painter = painter, contentDescription ="ImageView" )
        }

        Text(text = "Heading of the text ",)

        Text(text = "Main Description of the data  ")

        Text(text = "Author of the text")



    }


}