package com.scoproject.moviesapp.api

import com.google.gson.annotations.SerializedName

/**
 * Created by ibnumuzzakkir on 8/8/17.
 */

class BaseApiResponse<T> {
    var page: Int = 0
    var total_results: Int = 0
    var total_pages: Int = 0
    var status_code : Int = 0
    lateinit var status_message : String
    var results: T? = null
}
