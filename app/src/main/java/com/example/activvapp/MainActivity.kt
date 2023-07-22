package com.example.activvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.activvapp.ui.auth.AuthViewModel
import com.example.activvapp.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import net.simplifiedcoding.navigation.AppNavHost

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
