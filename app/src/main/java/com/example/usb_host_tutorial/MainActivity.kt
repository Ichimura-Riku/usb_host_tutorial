package com.example.usb_host_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.usb_host_tutorial.ui.screen.MainScreen
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme
import com.example.usb_host_tutorial.usecase.UsbPortManagerImpl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {




    init {

    }

//    val usbPortManager: UsbPortManager = viewModel.usbPortManager
//    private fun openPort(): () -> Boolean = {usbPortManager.openPort(this)}
    val usbPortManager = UsbPortManagerImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Usb_host_tutorialTheme {
                // A surface container using the 'background' color from the theme

                MainScreen(
                    terminalText = mutableListOf("hello"),
//                    openPort = openPort()
                    usbPortManager= usbPortManager
                )
//                MainScreen(terminalText = checkAllDevice())

            }
        }
    }

}


