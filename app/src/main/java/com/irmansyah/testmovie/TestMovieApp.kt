package com.irmansyah.testmovie

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.irmansyah.testmovie.di.AppModule
import org.koin.android.ext.android.startKoin

class TestMovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(AppModule.getModule()))

        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }
}