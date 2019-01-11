package com.irmansyah.testmovie.di

import com.irmansyah.testmovie.data.AppDataManager
import com.irmansyah.testmovie.data.DataManager
import com.irmansyah.testmovie.data.api.ApiHelper
import com.irmansyah.testmovie.data.api.AppApiHelper
import com.irmansyah.testmovie.ui.main.MainAdapter
import com.irmansyah.testmovie.ui.main.MainPresenter
import com.irmansyah.testmovie.ui.main.MainView
import com.irmansyah.testmovie.utils.SchedulerProvider
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AppModule {

    fun getModule(): Module = applicationContext {
        factory { MainPresenter<MainView>(get(), get()) }

        bean { AppDataManager(get()) as DataManager }
        bean { AppApiHelper() as ApiHelper }
        bean { SchedulerProvider() }

        bean { MainAdapter(ArrayList()) }
    }
}