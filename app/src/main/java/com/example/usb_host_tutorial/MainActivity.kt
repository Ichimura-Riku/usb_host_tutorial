package com.example.usb_host_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.usb_host_tutorial.ui.screen.MainScreen
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme
import com.example.usb_host_tutorial.ui.viewmodel.MainViewModel
import com.example.usb_host_tutorial.usecase.UsbPortManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {



//    lateinit var viewModel: MainViewModel

    init {

    }

//    val usbPortManager: UsbPortManager = viewModel.usbPortManager
//    private fun openPort(): () -> Boolean = {usbPortManager.openPort(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Usb_host_tutorialTheme {
                // A surface container using the 'background' color from the theme

                MainScreen(
                    terminalText = mutableListOf("hello"),
//                    viewModel = viewModel,
//                    openPort = openPort()
                )
//                MainScreen(terminalText = checkAllDevice())

            }
        }
    }

}


