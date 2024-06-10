package com.example.usb_host_tutorial.usecase

import android.app.Activity
import com.hoho.android.usbserial.driver.UsbSerialDriver

interface UsbPortManager {

    fun openPort(): Boolean
    fun closePort(): Boolean

    /**
     * わからんが、シリアルデータを流したいので、その情報をどう受け渡すか後で詰める
     * flowとかでやりたい
      */
    fun streamData(): UsbSerialDriver

}