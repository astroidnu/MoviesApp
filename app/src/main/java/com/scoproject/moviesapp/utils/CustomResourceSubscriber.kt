package com.scoproject.moviesapp.utils

import android.R.id.message
import android.support.annotation.NonNull
import android.util.Log
import com.scoproject.moviesapp.vo.Resource
import com.scoproject.moviesapp.vo.Status
import io.reactivex.subscribers.ResourceSubscriber
import java.io.IOException


/**
 * Created by ibnumuzzakkir on 8/8/17.
 */
abstract class CustomResourceSubscriber<T> : ResourceSubscriber<T>() {

    override fun onNext(t: T) {
        val resource = t as Resource<*>
        if (resource.status === Status.SUCCESS) {
            onNextAndCompleted(t)
        } else {
            onError(resource.message)
        }
    }

    abstract fun  onError(message: String?)

    protected abstract fun onNextAndCompleted(@NonNull body: T)

    override fun onError(e: Throwable) {
        if (e is IOException) {
            onError("No internet connection")
        } else {
            Log.d(javaClass.name, e.message)
            onError("Something's wrong")
        }
    }

    override fun onComplete() {

    }

}
