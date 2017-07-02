package com.scoproject.moviesapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.scoproject.moviesapp.R

class HomeActivity : AppCompatActivity(), HomeContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mToolbarTitle =  findViewById(R.id.toolbar_title) as TextView
        mToolbarTitle.setText("Home")

        val mFab = findViewById(R.id.main_fab) as FloatingActionButton
        mFab.setOnClickListener { view -> showSnackBar("Hello", view)}
    }

    override fun showSnackBar(msg: String, view : View) {
        Snackbar.make(view, "Hello", Snackbar.LENGTH_SHORT)
        .setAction("Action", null)
                .show()
    }
}
