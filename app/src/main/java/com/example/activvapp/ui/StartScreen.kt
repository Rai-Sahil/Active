package com.example.activvapp.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.activvapp.ui.auth.AuthHeader
import com.example.activvapp.ui.theme.AppTheme
import kotlinx.coroutines.delay
import net.simplifiedcoding.navigation.ROUTE_AUTHENTICATION_CHOICE

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StartScreen(navController: NavController) {

    LaunchedEffect(Unit){
        delay(2000)
        navController.navigate(ROUTE_AUTHENTICATION_CHOICE) {
            popUpTo(ROUTE_AUTHENTICATION_CHOICE)
        }
    }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (refHeader) = createRefs()

        Box(modifier = Modifier
            .constrainAs(refHeader){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            AuthHeader()
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Preview(){
    AppTheme {
        StartScreen(rememberNavController())
    }
}