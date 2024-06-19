package com.example.recipeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen (modifier:Modifier = Modifier,
                  viewState:mainViewModel.
                          RecipeState
                  , navToNextScreen:(Category) ->Unit){



    Scaffold (
       topBar =  { Appbar(tittle = "Recipes")}
    ){
        Column(
            modifier = Modifier.padding(it)
        ) {

            Box(modifier = Modifier.fillMaxSize()){

                when{
                    viewState.loading ->{
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                    viewState.error != null ->{
                        Text(text = "Error OCCURRED", textAlign = TextAlign.Center, fontSize = 25.sp)
                    }else ->{
                    CategoryScreen(categories = viewState.list,navToNextScreen)
                }
                }
            }
        }
    }

}

@Composable
fun CategoryScreen(categories:List<Category>,

                   navToNextScreen:(Category) ->Unit){
    LazyVerticalGrid(GridCells.Fixed(2),modifier = Modifier.fillMaxSize()){
         items(categories){
             categrois->
             ScreenItems(categrois = categrois,navToNextScreen)
         }
    }
}
@Composable
fun ScreenItems(categrois:Category,
                navToNextScreen:(Category) ->Unit
                ){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navToNextScreen(categrois) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card (
            shape = RoundedCornerShape(3.dp),
            border = BorderStroke(2.dp, color = Color(0xffe3d5ca)),
            elevation = 10.dp,
            backgroundColor = Color(0xffffe5d9)
        ){
            Image(
                painter = rememberAsyncImagePainter(model = categrois.strCategoryThumb), contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1.0f)
            )
                 Divider(thickness = 1.dp, modifier = Modifier.padding(start = 2.dp,end = 2.dp))
                Text(
                    text = categrois.strCategory,
                    color = Color.Black,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 4.dp, start = 20.dp)

                )
        }

    }
}



