package com.scoproject.moviesapp.api

import android.text.TextUtils
import android.util.Log
import retrofit2.HttpException
import java.io.IOException
import com.google.gson.Gson


/**
 * Created by ibnumuzzakkir on 8/27/17.
 */
class NetworkError(val err:Throwable): Throwable() {
    val DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again."
    val NETWORK_ERROR_MESSAGE = "No Internet Connection!"
    private val ERROR_MESSAGE_HEADER = "Error-Message"

    fun getErrorMessage(): String {
        if (err is IOException){
            return NETWORK_ERROR_MESSAGE
        }
        if (err !is HttpException){
            return DEFAULT_ERROR_MESSAGE
        }
        val response = err.response()
        if (response != null) {
            val status = getJsonStringFromResponse(response)
            if (!TextUtils.isEmpty(status)){
                return status!!
            }
            val headers = response.headers().toMultimap()
            if (headers.containsKey(ERROR_MESSAGE_HEADER)){
                return headers.get(ERROR_MESSAGE_HEADER)?.get(0)!!
            }
        }
        return DEFAULT_ERROR_MESSAGE
    }

     fun getJsonStringFromResponse(response: retrofit2.Response<*>): String? {
        try {
            Log.d(javaClass.name, response.code().toString())
            val jsonString = response.errorBody()!!.string()
            val errorResponse = Gson().fromJson(jsonString, BaseApiResponse::class.java)
            return errorResponse.status_message
        } catch (e: Exception) {
            return null
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as NetworkError?

        return err.equals(that!!.err)
    }

    override fun hashCode(): Int {
        return err.hashCode()
    }

}