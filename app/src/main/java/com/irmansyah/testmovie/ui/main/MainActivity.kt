package com.irmansyah.testmovie.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.irmansyah.testmovie.R
import com.irmansyah.testmovie.data.model.Movie
import com.irmansyah.testmovie.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import EndlessOnScrollListener
import android.content.Intent
import com.irmansyah.testmovie.ui.detail.DetailActivity


class MainActivity : BaseActivity(), MainView {



    companion object {
        const val TAG = "MainActivity"
    }

    val presenter: MainPresenter<MainView> by inject()
    val adapter: MainAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        presenter.requestList()

        adapter.setOnItemCLickListener {
            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra(DetailActivity.INTENT_MOVIE, it)
            startActivity(intent)
        }

        swipe_refresh.setOnRefreshListener {
            presenter.requestList()
        }

        movie_rv.addOnScrollListener(scrollData("1"))

        setupRv()
    }

    private fun scrollData(page: String): EndlessOnScrollListener {
        return object : EndlessOnScrollListener() {
            override fun onLoadMore() {

            }
        }
    }

    private fun setupRv() {
        movie_rv.layoutManager = LinearLayoutManager(this)
        movie_rv.adapter = adapter
    }

    override fun addMovieToList(movies: List<Movie>) {
        swipe_refresh.isRefreshing = false
        adapter.addToList(movies)
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
