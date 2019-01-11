package com.irmansyah.testmovie.ui.main

import com.irmansyah.testmovie.data.model.Movie
import com.irmansyah.testmovie.ui.base.MVPView

interface MainView : MVPView {

    fun addMovieToList(movies: List<Movie>)
}