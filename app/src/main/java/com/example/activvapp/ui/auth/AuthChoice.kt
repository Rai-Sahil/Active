package com.example.activvapp.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.activvapp.R
import com.example.activvapp.ui.theme.AppTheme
import com.example.activvapp.ui.theme.spacing
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SIGNUP

@Composable
fun AuthChoiceScreen(navController: NavController) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (refHeader, refButton, refText) = createRefs()
        val spacing = MaterialTheme.spacing

        Box(modifier = Modifier
            .constrainAs(refHeader) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, spacing.doubleDoubleExtraLarge)
                width = Dimension.fillToConstraints
            }
            .wrapContentSize()
        ){
            AuthHeader()
        }

        Button (
            onClick = {
                      navController.navigate(ROUTE_SIGNUP)
            },
            modifier = Modifier.constrainAs(refButton) {
                bottom.linkTo(parent.bottom, spacing.doubleExtraLarge)
                start.linkTo(parent.start, spacing.medium)
                end.linkTo(parent.end, spacing.medium)
                width = Dimension.fillToConstraints
                height = Dimension.value(55.dp)
            },
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(text = stringResource(id = R.string.signup),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 15.sp)
        }

        Text(text = stringResource(id = R.string.signin),
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 15.sp,
            modifier = Modifier.constrainAs(refText){
                bottom.linkTo(parent.bottom, spacing.large)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .clickable {
                navController.navigate(ROUTE_LOGIN)
            },
            color = Color.White
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview(){
    AppTheme {
        AuthChoiceScreen(rememberNavController())
    }
}