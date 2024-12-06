package com.gg.spora.core

import android.app.Application
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SporaApp : Application(){
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}