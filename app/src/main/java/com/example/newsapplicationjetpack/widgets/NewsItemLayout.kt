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
import androidx.compose.ui.unit.sp
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

        Text(text = "Heading of the text ", fontSize = 14.sp)

        Text(text = "Main Description of the data  ", fontSize = 12.sp , maxLines = 3,)

        Text(text = "Author of the text", fontSize = 10.sp)



    }


}