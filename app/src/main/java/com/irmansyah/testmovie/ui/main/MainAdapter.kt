package com.irmansyah.testmovie.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irmansyah.testmovie.R
import com.irmansyah.testmovie.data.model.Movie
import kotlinx.android.synthetic.main.item_movie_list.view.*

class MainAdapter(private val movies: ArrayList<Movie>): RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    private lateinit var mListener: (Movie) -> Unit

    fun setOnItemCLickListener(listener: (Movie) -> Unit) {
        this.mListener = listener
    }

    override fun getItemCount(): Int = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movies[position], mListener)
    }

    fun addToList(movie: List<Movie>) {
        movies.clear()
        movies.addAll(movie)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(movie: Movie, listener: (Movie) -> Unit) {
            itemView.title.text = movie.title

            itemView.setOnClickListener { listener(movie) }
        }
    }
}