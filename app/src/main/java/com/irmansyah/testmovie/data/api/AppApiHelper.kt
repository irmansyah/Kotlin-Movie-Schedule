package com.irmansyah.testmovie.data.api

import com.irmansyah.testmovie.data.model.MovieResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class AppApiHelper : ApiHelper {

    override fun performUpcomingMovie(): Single<MovieResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_MOVIE_UPCOMING_API)
            .addQueryParameter("api_key", ApiEndPoint.API_KEY)
            .addQueryParameter("language", "en-US")
            .build()
            .getObjectSingle(MovieResponse::class.java)
}