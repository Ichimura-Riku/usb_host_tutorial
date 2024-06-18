package com.example.usb_host_tutorial.usecase

import android.app.PendingIntent
import android.content.Context
import android.content.Context.USB_SERVICE
import android.content.Intent
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion.ACTION_REQUEST_PERMISSIONS
import androidx.annotation.RequiresApi
import com.hoho.android.usbserial.driver.UsbSerialDriver
import com.hoho.android.usbserial.driver.UsbSerialPort
import com.hoho.android.usbserial.driver.UsbSerialProber
import javax.inject.Inject


class UsbPortManagerImpl @Inject constructor(
    private val context: Context
) : UsbPortManager {
    private lateinit var _availableDrivers: List<UsbSerialDriver>
    private var _portStatus = "Disconnection"

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun openPort(): Boolean {
        context.getSystemService(USB_SERVICE)
        val intent = Intent(ACTION_REQUEST_PERMISSIONS) // 仮のintentActionを入れている
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context,  1, intent, PendingIntent.FLAG_IMMUTABLE  )
        val usbManager = context.getSystemService(USB_SERVICE) as UsbManager
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
                }// add UsbManager.requestPermission(driver.getDevice(), ..) handling here
            val port = driver.ports[0] // Most devices have just one port (port 0)
            return try {
                port.open(connection)
                port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE)
                _portStatus = "clear"
                true
            }catch(e: Exception) {
                _portStatus = "Cannot open port"
                false
            }
        }
    }

    override fun getPortStatus(): String {
        return _portStatus
    }

    override fun closePort(): Boolean {
        // Todo
        return false
    }

    override fun streamData(): UsbSerialDriver {
        return _availableDrivers[0]
    }


}