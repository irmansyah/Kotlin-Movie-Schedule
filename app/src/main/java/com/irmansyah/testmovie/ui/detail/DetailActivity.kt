package com.irmansyah.testmovie.ui.detail

import android.os.Build
import android.os.Bundle
import com.irmansyah.testmovie.BuildConfig
import com.irmansyah.testmovie.R
import com.irmansyah.testmovie.data.model.Movie
import com.irmansyah.testmovie.ui.base.BaseActivity
import com.irmansyah.testmovie.utils.extension.loadImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    companion object {
        const val TAG = "DetailActivity"
        const val INTENT_MOVIE = "INTENT_MOVIE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent.getParcelableExtra<Movie>(INTENT_MOVIE)

        imageView.loadImage(movie.posterPath + BuildConfig.BASE_URL_POSTER_PATH_BIG)
        title_tv.text = movie.title
    }
}
