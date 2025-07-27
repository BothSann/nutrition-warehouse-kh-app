package org.itstep.nutritionwarehouse

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import com.nutritionwarehouse.di.initializeKoin
import org.koin.android.ext.koin.androidContext

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Koin
        initializeKoin (
            config = {
                androidContext(this@MyApplication)
            }
        )
        Firebase.initialize(context = this)
    }

}