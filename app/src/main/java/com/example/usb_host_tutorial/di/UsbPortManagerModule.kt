package com.example.usb_host_tutorial.di
import android.content.Context
import com.example.usb_host_tutorial.usecase.UsbPortManager
import com.example.usb_host_tutorial.usecase.UsbPortManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object UsbPortManagerModule {
    @Singleton
    @Provides
    fun bindsUsbPortManager(
        @ApplicationContext context: Context
    ): UsbPortManager{
        return UsbPortManagerImpl(context = context)
    }




}

