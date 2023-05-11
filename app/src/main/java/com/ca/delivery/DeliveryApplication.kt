package com.ca.delivery

import android.app.Application
import com.ca.auth.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class DeliveryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@DeliveryApplication)
            modules(
                listOf(
                    authModule
                )
            )
        }
    }
}