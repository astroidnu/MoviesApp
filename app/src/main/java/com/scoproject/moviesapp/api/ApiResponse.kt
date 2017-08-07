package com.scoproject.moviesapp.api

import org.json.JSONException
import org.json.JSONObject
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.util.ArrayMap;
import retrofit2.Response
import java.io.IOException
import java.util.*
import java.util.regex.Pattern
import java.util.Collections.emptyMap




/**
 * Created by ibnumuzzakkir on 8/2/17.
 */

class ApiResponse<T>(response: Response<T>) {
    val code: Int
    val body: T?
    val errorMessage: String?
    val links: MutableMap<String, String>

    init {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
            errorMessage = null
        } else {
            var message: String? = null
            if (response.errorBody() != null) {
                try {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    message = jObjError.getString("status_message")
                } catch (ignored: IOException) {
                    //                    Timber.e(ignored, "error while parsing response");
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }
            if (message == null || message.trim { it <= ' ' }.length == 0) {
                message = response.message()
            }
            errorMessage = message
            body = null
        }
        val linkHeader = response.headers().get("link")
        if (linkHeader == null) {
            links = Collections.emptyMap()
        } else {
            links = ArrayMap<String, String>()
            val matcher = LINK_PATTERN.matcher(linkHeader)

            while (matcher.find()) {
                val count = matcher.groupCount()
                if (count == 2) {
                    links.put(matcher.group(2), matcher.group(1))
                }
            }
        }
    }

    val isSuccessful: Boolean
        get() = code >= 200 && code < 300

    companion object {
        private val LINK_PATTERN = Pattern
                .compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"")
    }

}