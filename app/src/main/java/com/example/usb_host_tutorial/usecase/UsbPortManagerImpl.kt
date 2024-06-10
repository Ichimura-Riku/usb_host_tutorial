package com.example.usb_host_tutorial.usecase

import android.app.Activity
import android.content.Context.USB_SERVICE
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import com.hoho.android.usbserial.driver.UsbSerialDriver
import com.hoho.android.usbserial.driver.UsbSerialPort
import com.hoho.android.usbserial.driver.UsbSerialProber
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject


class UsbPortManagerImpl @Inject constructor(
//    private val activity: Activity
) : UsbPortManager {
    private lateinit var _usbManager: UsbManager
    private lateinit var _availableDrivers: List<UsbSerialDriver>

    //
    override fun openPort(): Boolean {
//         _usbManager = activity.getSystemService(USB_SERVICE) as UsbManager
//        _availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(_usbManager)
//        if (_availableDrivers.isEmpty()) {
//            return false
//        } else {
//            val driver: UsbSerialDriver = _availableDrivers[0]
//            val connection : UsbDeviceConnection = _usbManager.openDevice(driver.device)
//                ?: // add UsbManager.requestPermission(driver.getDevice(), ..) handling here
//                return false
//            val port = driver.ports[0] // Most devices have just one port (port 0)
//            return try {
//                port.open(connection)
//                port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE)
//                true
//            }catch(e: Exception) {
//                false
//            }
//        }
        return false
    }

    override fun closePort(): Boolean{
        // Todo
        return false
    }

    override fun streamData(): UsbSerialDriver {
        return _availableDrivers[0]
    }


}