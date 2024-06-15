package com.example.usb_host_tutorial.usecase

import android.app.Activity
import android.content.Context.USB_SERVICE
import android.hardware.usb.UsbDeviceConnection
import android.hardware.usb.UsbManager
import android.util.Log
import com.hoho.android.usbserial.driver.UsbSerialDriver
import com.hoho.android.usbserial.driver.UsbSerialPort
import com.hoho.android.usbserial.driver.UsbSerialProber


class UsbPortManagerImpl (
    private val activity: Activity
) : UsbPortManager {
    private lateinit var _usbManager: UsbManager
    private lateinit var _availableDrivers: List<UsbSerialDriver>
    private var _portStatus = "clear"

    //
    override fun openPort(): Boolean {
//        activity.getSystemService(USB_SERVICE)
//         _usbManager = activity.getSystemService(USB_SERVICE) as UsbManager
//        _availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(_usbManager)
//        if (_availableDrivers.isEmpty()) {
//            _portStatus = "isEmpty available Drivers"
//            return false
//        } else {
//            val driver: UsbSerialDriver = _availableDrivers[0]
//
//
//            val connection : UsbDeviceConnection = _usbManager.openDevice(driver.device)
//                ?: run {
//                    _portStatus = "Cannot open device"
//                    return false
//                }// add UsbManager.requestPermission(driver.getDevice(), ..) handling here
//            val port = driver.ports[0] // Most devices have just one port (port 0)
//            return try {
//                port.open(connection)
//                port.setParameters(115200, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE)
//                true
//            }catch(e: Exception) {
//                _portStatus = "Cannot open port"
//                false
//            }
//        }
        return true
    }

    override fun getPortStatus(): String{
        return _portStatus
    }

    override fun closePort(): Boolean{
        // Todo
        return false
    }

    override fun streamData(): UsbSerialDriver {
        return _availableDrivers[0]
    }


}