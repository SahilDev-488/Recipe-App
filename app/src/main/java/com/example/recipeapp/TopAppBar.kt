package com.example.recipeapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Appbar(
    tittle:String,
    onBackClick:() -> Unit = {}
){
    val navigation : (@Composable () -> Unit)? =
        if(!tittle.contains("Recipes")){
            {
                IconButton(onClick = { onBackClick() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back"
                        )
                }
            }
    }else{
        null
    }

    TopAppBar(title = { Text(text = tittle,
        modifier = Modifier
            .padding(start = 4.dp)
            .heightIn(max = 24.dp),
        color = Color(0xff212529),

    )
    },
        backgroundColor = Color(0xffc8b6ff),
        navigationIcon = navigation
    )
}

