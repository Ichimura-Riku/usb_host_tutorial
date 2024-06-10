package com.example.usb_host_tutorial.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme
import com.example.usb_host_tutorial.ui.viewmodel.MainViewModel
import javax.inject.Inject


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    terminalText : List<String>,
    viewModel: MainViewModel,
//    openPort: () -> Boolean,

){
    viewModel.usbPortManager

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ){

            if (terminalText.isNotEmpty()) Text(terminalText[0]) else Text(text = "Empty")
        }
    }
}

