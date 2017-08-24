package com.scoproject.moviesapp

import com.scoproject.moviesapp.repository.MovieRepository
import com.scoproject.moviesapp.ui.home.HomeContract
import org.junit.runner.RunWith
import org.mockito.Mock
import com.scoproject.moviesapp.ui.home.HomeContract.UserActionListener
import com.scoproject.moviesapp.ui.home.HomePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


/**
 * Created by ibnumuzzakkir on 8/24/17.
 */
@RunWith(JUnit4::class)
class MoviePresenterTest{

    @Mock private lateinit var mHomeView: HomeContract.View

    @Mock private lateinit var mActionListener: HomeContract.UserActionListener

    @Mock
    lateinit var mMovieRepository: MovieRepository

    lateinit var homePresenter:HomePresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        homePresenter = HomePresenter(mMovieRepository)
        mActionListener = homePresenter
        homePresenter.setView(mHomeView)
    }

    @Test
    fun checkingUI(){
        assert(true).equals(R.id.main_fab)
    }
    
}