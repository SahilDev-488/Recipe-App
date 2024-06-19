package com.example.recipeapp


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter


@Composable
fun CategoryDetailScreen(category: Category,
                         navController: NavController
                         ){

    val title = remember{
        mutableStateOf(category.strCategory)
    }

    Scaffold(
      topBar = { Appbar(tittle = title.value
      ){
          navController.navigateUp()
      }
      }
    ) {
        Column (
            modifier = Modifier.padding(it)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = category.strCategory, textAlign = TextAlign.Center)
                Image(painter = rememberAsyncImagePainter(model = category.strCategoryThumb)
                    , modifier = Modifier
                        .wrapContentSize()
                        .aspectRatio(1.0f)
                    , contentDescription ="${category.strCategoryThumb}" )
                Card (
                    shape = RoundedCornerShape(3.dp),
                    border = BorderStroke(2.dp, color = Color(0xffe3d5ca)),
                    elevation = 10.dp,
                    backgroundColor = Color(0xffffe5d9),
                    modifier = Modifier.clickable {  }
                ){
                    Text(text = category.strCategoryDescription,modifier =Modifier.verticalScroll(
                        rememberScrollState()),
                        textAlign = TextAlign.Justify
                    )
                }
            }

        }
    }

}

