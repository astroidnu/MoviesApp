package com.scoproject.moviesapp.utils

import android.util.Log
import com.scoproject.moviesapp.api.ApiResponse
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type
import org.reactivestreams.Subscriber
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.atomic.AtomicBoolean








/**
 * Created by ibnumuzzakkir on 8/2/17.
 */
class FlowableCallAdapter<R>(private val responseType: Type) : CallAdapter<R, Flowable<ApiResponse<R>>> {

    private val TAG = FlowableCallAdapter::class.java.simpleName

    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<R>): Flowable<ApiResponse<R>> {
        return object : Flowable<ApiResponse<R>>() {
            internal var started = AtomicBoolean(false)
            override fun subscribeActual(s: Subscriber<in ApiResponse<R>>) {
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            Log.d(TAG, "onResponse")
                            s.onNext(ApiResponse(response))
                        }

                        override fun onFailure(call: Call<R>, throwable: Throwable) {
                            Log.d(TAG, "onFailure")
                            s.onError(throwable)
                            //                            s.onNext(new ApiResponse<R>(throwable));
                        }
                    })
                }
            }
        }
    }

}