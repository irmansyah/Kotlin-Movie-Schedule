package com.irmansyah.testmovie.ui.main

import android.util.Log
import com.irmansyah.testmovie.data.DataManager
import com.irmansyah.testmovie.ui.base.BasePresenter
import com.irmansyah.testmovie.utils.SchedulerProvider

class MainPresenter<V : MainView> constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BasePresenter<V>(dataManager = dataManager, schedulerProvider = schedulerProvider) {

    fun requestList() {
        compositeDisposable.add(dataManager.performUpcomingMovie()
            .compose(schedulerProvider.ioToMainSingleScheduler())
            .subscribe({ response ->

                Log.i(MainActivity.TAG, response.results?.size.toString())

                response.results?.let { getView()?.addMovieToList(it) }


            }, {

                Log.e(MainActivity.TAG, it.message)

            }))
    }
}