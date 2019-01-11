package com.irmansyah.testmovie.data.api

import com.irmansyah.testmovie.data.model.MovieResponse
import io.reactivex.Single

interface ApiHelper {

    fun performUpcomingMovie(): Single<MovieResponse>
}