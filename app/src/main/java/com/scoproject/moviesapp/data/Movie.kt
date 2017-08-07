package com.scoproject.moviesapp.data

import android.os.Parcel
import com.google.gson.annotations.SerializedName
import android.os.Parcelable



/**
 * Created by ibnumuzzakkir on 8/8/17.
 */
class Movie : Parcelable {
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

    constructor() {}

    protected constructor(`in`: Parcel) {
        voteCount = `in`.readInt()
        id = `in`.readLong()
        isVideo = `in`.readByte().toInt() != 0
        voteAverage = `in`.readFloat()
        title = `in`.readString()
        popularity = `in`.readFloat()
        posterPath = `in`.readString()
        originalLanguage = `in`.readString()
        originalTitle = `in`.readString()
        backdropPath = `in`.readString()
        isAdult = `in`.readByte().toInt() != 0
        overview = `in`.readString()
        releaseDate = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeInt(voteCount)
        parcel.writeLong(id)
        parcel.writeByte((if (isVideo) 1 else 0).toByte())
        parcel.writeFloat(voteAverage)
        parcel.writeString(title)
        parcel.writeFloat(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeByte((if (isAdult) 1 else 0).toByte())
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(`in`: Parcel): Movie {
                return Movie(`in`)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}
