package net.simplifiedcoding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.activvapp.ui.StartScreen
import com.example.activvapp.ui.auth.AuthViewModel
import com.example.activvapp.ui.auth.LoginScreen
import com.example.activvapp.ui.auth.AuthChoiceScreen
import com.example.activvapp.ui.auth.SignupScreen
import com.example.activvapp.ui.home.HomeScreen

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_START_SCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_START_SCREEN) {
            StartScreen(navController)
        }
        composable(ROUTE_AUTHENTICATION_CHOICE) {
            AuthChoiceScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }
    }
}