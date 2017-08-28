package com.scoproject.moviesapp.data

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by ibnumuzzakkir on 8/25/17.
 */
open class Movie : RealmObject() {
    @SerializedName("vote_count")
    var voteCount: Int = 0
    @SerializedName("id")
    var id: Long = 0
    @SerializedName("video")
    var isVideo: Boolean = false
    @SerializedName("vote_average")
    var voteAverage: Float = 0.toFloat()
    @SerializedName("title")
    var title: String? = null
    @SerializedName("populatiry")
    var popularity: Float = 0.toFloat()
    @SerializedName("poster_path")
    var posterPath: String? = null
    @SerializedName("original_language")
    var originalLanguage: String? = null
    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
    @SerializedName("adult")
    var isAdult: Boolean = false
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
}