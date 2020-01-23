package com.moeiny.reza.ninenews.model.repository

import retrofit2.Retrofit

object NewsRepositoryProvider {

    fun provideNewsRepository(retrofit: Retrofit) : NewsRepository {
        return NewsRepository(NewsApiService.create(retrofit))
    }
}