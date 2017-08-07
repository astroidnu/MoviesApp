package com.scoproject.moviesapp.api

import com.scoproject.moviesapp.vo.Resource


/**
 * Created by ibnumuzzakkir on 8/8/17.
 */
class ApiWrapper {
    fun <T> fetchApi(response: ApiResponse<BaseApiResponse<T>>): Resource<T?> {
        if (response.isSuccessful) {
            if (response.body != null) {
                return Resource.success(response.body!!.results)
            }
        } else {
            return Resource.error(response.errorMessage!!, null)
        }
        return Resource.error("Somethings Wrong", null)
    }
}
