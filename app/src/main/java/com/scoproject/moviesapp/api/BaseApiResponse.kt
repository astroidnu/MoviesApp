package com.scoproject.moviesapp.api

/**
 * Created by ibnumuzzakkir on 8/8/17.
 */

class BaseApiResponse<T> {
    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
    var results: T? = null
}
