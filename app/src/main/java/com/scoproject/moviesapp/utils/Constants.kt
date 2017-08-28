package com.scoproject.moviesapp.utils

/**
 * Created by ibnumuzzakkir on 8/2/17.
 */
class Constants{
    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        //    var TOKEN = BuildConfig.THE_MOVIE_DB_API_KEY
        var BASE_URL_IMAGE = "http://image.tmdb.org/t/p/w780/"
        var BASE_URL_IMAGE_BACKDROP = "http://image.tmdb.org/t/p"
    }


    interface SORT_TYPE {
        companion object {
            val POPULAR_MOVIES = 0
            val TOP_RATED_MOVIES = 1
            val FAVORITE = 2
        }
    }

    interface ADAPTER_TYPE {
        companion object {
            val TRAILER_ADAPTER = 0
            val REVIEW_ADAPTER = 1
        }
    }

    interface INTENT_TAG {
        companion object {
            val TAG_SOURCE = "source"
            val TAG_DATA = "data"
        }
    }
}