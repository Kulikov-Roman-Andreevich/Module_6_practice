package com.roman_kulikov.data.api.interceptors

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class CodeLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val response = chain.proceed(request)

        Log.d("HTTP_RESPONSE", "URL: ${request.url} — Response code: ${response.code}")

        return response
    }
}