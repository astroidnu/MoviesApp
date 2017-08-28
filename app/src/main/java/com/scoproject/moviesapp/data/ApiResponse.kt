package com.scoproject.moviesapp.data

import com.google.gson.annotations.SerializedName



/**
 * Created by ibnumuzzakkir on 8/27/17.
 */
class ApiResponse {
    @SerializedName("results")
    var results: List<Movie>? = null
}