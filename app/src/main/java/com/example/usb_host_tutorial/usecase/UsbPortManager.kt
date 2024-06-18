package com.example.usb_host_tutorial.usecase

import android.app.Activity
import com.hoho.android.usbserial.driver.UsbSerialDriver

interface UsbPortManager {

    fun openPort(): Boolean
    fun closePort(): Boolean
    fun streamData(): UsbSerialDriver
    fun getPortStatus(): String
}