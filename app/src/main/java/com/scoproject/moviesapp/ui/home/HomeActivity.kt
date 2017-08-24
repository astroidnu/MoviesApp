package com.scoproject.moviesapp.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.scoproject.moviesapp.MovieApp
import com.scoproject.moviesapp.R
import com.scoproject.moviesapp.adapter.MovieAdapter
import com.scoproject.moviesapp.data.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HomeContract.View {

    @Inject lateinit var homePresenter: HomePresenter
    private var mActionListener: HomeContract.UserActionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActivityComponent()
        setupLayout()
        mActionListener = homePresenter
        homePresenter.setView(this)
        homePresenter.getMovieData()
    }

    override fun setupLayout(){
        toolbar_title.setText("Home")
        main_fab.setOnClickListener { view-> showSnackBar("Hello from Anko", view) }
    }

    override fun showSnackBar(msg: String, view : View) {
        Snackbar.make(view, "Hello", Snackbar.LENGTH_SHORT)
        .setAction("Action", null)
                .show()
    }


    private fun setupActivityComponent() {
        MovieApp.appComponent
                .plus(HomeModule(this))
                .inject(this)
    }

    override fun setAdapter(movie: List<Movie>) {
        movie_recycleview.layoutManager = LinearLayoutManager(this)
        movie_recycleview.hasFixedSize()
        movie_recycleview.adapter = MovieAdapter(movie)
    }

    override fun showLoadingbar() {
        movie_progressbar.visibility = View.VISIBLE
    }
}
