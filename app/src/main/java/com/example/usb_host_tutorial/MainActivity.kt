package com.example.usb_host_tutorial

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.usb_host_tutorial.ui.screen.MainScreen
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Usb_host_tutorialTheme {
                // A surface container using the 'background' color from the theme
                checkAllDevice()

                MainScreen(terminalText = checkAllDevice())

            }
        }
    }
    // useCaseクラスを作って、viewModelで受け渡しをする設計にする
    private fun checkAllDevice(): List<String> {
        val manager = getSystemService(Context.USB_SERVICE) as UsbManager
        val deviceList:  Map<String, UsbDevice> = manager.getDeviceList()
        val deviceNameList:  List<String> = deviceList.keys.toList()
        return deviceNameList


    }
}


