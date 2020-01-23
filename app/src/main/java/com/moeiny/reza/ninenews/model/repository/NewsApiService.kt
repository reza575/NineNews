package com.moeiny.reza.ninenews.model.repository

import com.moeiny.reza.ninenews.model.entity.News
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.http.*

interface NewsApiService {

    @GET
    fun getNewsInfo(@Url url: String): Flowable<News>


    companion object Factory {
        fun create(retrofit: Retrofit): NewsApiService {
            return retrofit.create(NewsApiService::class.java)
        }
    }
}