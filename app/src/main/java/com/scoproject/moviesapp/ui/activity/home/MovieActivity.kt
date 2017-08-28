package com.scoproject.moviesapp.ui.activity.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.scoproject.moviesapp.MovieApp
import com.scoproject.moviesapp.R
import com.scoproject.moviesapp.adapter.MovieAdapter
import com.scoproject.moviesapp.data.Movie
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MovieActivity : AppCompatActivity(), MovieContract.View {
    @Inject lateinit var moviePresenter: MoviePresenter
    private var mActionListener: MovieContract.UserActionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        setupActivityComponent()
        setupLayout()
        mActionListener = moviePresenter
        moviePresenter.setView(this)
        moviePresenter.getMovieData()
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
                .plus(MovieModule(this))
                .inject(this)
    }

    override fun setAdapter(movieModel: List<Movie>) {
        setLoadingBar(false)
        movie_recycleview.layoutManager = LinearLayoutManager(this)
        movie_recycleview.hasFixedSize()
        movie_recycleview.adapter = MovieAdapter(movieModel)
    }

    override fun setLoadingBar(status: Boolean) {
        var visibilty : Int
        if(status){
            visibilty = View.VISIBLE
        }else{
            visibilty = View.GONE
        }
        movie_progressbar.visibility = visibilty
    }

    override fun showToast(msg: String) {
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }

}
