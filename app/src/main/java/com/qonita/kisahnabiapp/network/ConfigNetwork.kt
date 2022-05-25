package com.qonita.kisahnabiapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ConfigNetwork {
    fun getRetrofit(): Retrofit{
        return  Retrofit
            .Builder()
            .baseUrl("https://islamic-api-zhirrr.vercel.app/api/kisahnabi")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    fun service (): ServiceApi = getRetrofit().create(ServiceApi::class.java)
}