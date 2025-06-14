package com.roman_kulikov.data.api

import com.roman_kulikov.data.api.interceptors.CodeLoggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://bouquets.tiiny.site/"
private const val BASE_URL_1 = "https://api.jsonsilo.com/"

object BouquetsClient {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val client = OkHttpClient.Builder().addInterceptor(CodeLoggingInterceptor()).build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(BASE_URL).build()

    val apiService = retrofit.create(BouquetRetrofit::class.java)
}