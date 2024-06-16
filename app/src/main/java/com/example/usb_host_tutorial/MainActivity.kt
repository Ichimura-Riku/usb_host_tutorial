package com.example.usb_host_tutorial

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.usb_host_tutorial.ui.screen.MainScreen
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Usb_host_tutorialTheme {
                MainScreen()
            }
        }
    }
}


