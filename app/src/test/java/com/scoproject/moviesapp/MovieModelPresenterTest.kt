package com.scoproject.moviesapp

import com.scoproject.moviesapp.repository.MovieRepository
import com.scoproject.moviesapp.ui.activity.home.MovieContract
import org.junit.runner.RunWith
import org.mockito.Mock
import com.scoproject.moviesapp.ui.activity.home.MoviePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.verify


/**
 * Created by ibnumuzzakkir on 8/24/17.
 */
@RunWith(JUnit4::class)
class MovieModelPresenterTest {

    @Mock private lateinit var mMovieView: MovieContract.View

    @Mock private lateinit var mActionListener: MovieContract.UserActionListener

    @Mock
    lateinit var mMovieRepository: MovieRepository

    lateinit var moviePresenter: MoviePresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        moviePresenter = MoviePresenter(mMovieRepository)
        mActionListener = moviePresenter
        moviePresenter.setView(mMovieView)
    }

    @Test
    fun checkingProgressBar(){
        mActionListener.getMovieData()
        verify(mMovieView).setLoadingBar(true)
    }
    
}