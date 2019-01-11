package com.irmansyah.testmovie.data

import com.irmansyah.testmovie.data.api.ApiHelper
import com.irmansyah.testmovie.data.model.MovieResponse
import io.reactivex.Single

class AppDataManager(private val apiHelper: ApiHelper) : DataManager {

    override fun performUpcomingMovie(): Single<MovieResponse> = apiHelper.performUpcomingMovie()
}