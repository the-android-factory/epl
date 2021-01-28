package com.androidfactory.epl

import android.app.Application

class EplApplication: Application() {

    companion object {
        lateinit var application: EplApplication
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        SharedPrefUtil.init(this)
    }
}