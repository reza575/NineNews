package com.moeiny.reza.ninenews.presenter

import com.moeiny.reza.ninenews.model.entity.News
import com.moeiny.reza.ninenews.utils.NineNewsCallback


interface INewsService {

    fun getNewsInfo(block: NineNewsCallback<News, Throwable>)


}