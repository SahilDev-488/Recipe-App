package com.example.recipeapp

import androidx.annotation.DrawableRes

sealed class Screenitem(
    val title:String,
    val route:String
)
{
    sealed class drawritem(
        dtitle:String,
        droute:String,
        @DrawableRes icon:Int
    ):Screenitem(dtitle,droute)
    {
        object home:drawritem(
            "Home",
            "home",
            R.drawable.baseline_home_24
        )
     object account:drawritem(
         "Account",
         "account",
         R.drawable.account_circle_24
     )
        object about:drawritem(
            "About",
            "about",
            R.drawable.baseline_question_mark_24
        )
    }

}
val drawrlist = listOf(
    Screenitem.drawritem.home,
    Screenitem.drawritem.account,
    Screenitem.drawritem.about
)
