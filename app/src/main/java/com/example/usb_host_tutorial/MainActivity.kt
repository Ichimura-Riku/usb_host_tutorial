package com.example.usb_host_tutorial

import android.app.PendingIntent
import android.content.Intent
import android.content.Intent.ACTION_MAIN
import android.content.Intent.ACTION_VIEW_PERMISSION_USAGE
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion.ACTION_REQUEST_PERMISSIONS
import androidx.annotation.RequiresApi
import com.example.usb_host_tutorial.ui.screen.MainScreen
import com.example.usb_host_tutorial.ui.theme.Usb_host_tutorialTheme
import com.example.usb_host_tutorial.usecase.UsbPortManager
import com.example.usb_host_tutorial.usecase.UsbPortManagerImpl
import com.hoho.android.usbserial.driver.UsbSerialDriver
import com.hoho.android.usbserial.driver.UsbSerialPort
import com.hoho.android.usbserial.driver.UsbSerialProber
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {




    init {

    }

//    val usbPortManager: UsbPortManager = viewModel.usbPortManager
//    private fun openPort(): () -> Boolean = {usbPortManager.openPort(this)}
    private var _portStatus: String = "clear"

    val usbPortManager = UsbPortManagerImpl(this)
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  isOpenPort = usbPortManager.openPort()
        openPortInActivity()
        setContent {
            Usb_host_tutorialTheme {
                // A surface container using the 'background' color from the theme

                MainScreen(
                    isOpenPort = isOpenPort,
                    usbPortManager= usbPortManager,
                    portStatus = _portStatus,
                )
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun openPortInActivity(): Boolean {
        this.getSystemService(USB_SERVICE)
        val intent = Intent(ACTION_REQUEST_PERMISSIONS) // 仮のintentActionを入れている
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this,  1, intent, PendingIntent.FLAG_IMMUTABLE  )
        val usbManager = this.getSystemService(USB_SERVICE) as UsbManager
        val availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(usbManager)
        if (availableDrivers.isEmpty()) {
            _portStatus = "isEmpty available Drivers"
            return false
        } else {
            val driver: UsbSerialDriver = availableDrivers[0]

            val connection : UsbDeviceConnection = usbManager.openDevice(driver.device)
                ?: run {
                    usbManager.requestPermission(driver.device, pendingIntent)
                    usbManager.openDevice(driver.device)
//                    _portStatus = "Cannot open device"
//                    return false
                }// add UsbManager.requestPermission(driver.getDevice(), ..) handling here
            val port = driver.ports[0] // Most devices have just one port (port 0)
            return try {
                port.open(connection)
                port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE)
                true
            }catch(e: Exception) {
                _portStatus = "Cannot open port"
                false
            }
        }
    }

}


