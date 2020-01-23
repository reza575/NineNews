package com.moeiny.reza.ninenews.model.repository

import com.moeiny.reza.ninenews.model.entity.News
import com.moeiny.reza.ninenews.utils.API
import io.reactivex.Flowable

class NewsRepository(private val newsApiService: NewsApiService) {

    fun getNewsInfo(): Flowable<News> {
        return newsApiService.getNewsInfo(API.GET_NEWS_URL.value)
    }

}