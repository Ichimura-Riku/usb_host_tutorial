package com.example.usb_host_tutorial.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.usb_host_tutorial.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    terminalText : List<String>,
    viewModel: MainViewModel = hiltViewModel(),
//    openPort: () -> Boolean,

){
    viewModel.usbPortManager.openPort()
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

