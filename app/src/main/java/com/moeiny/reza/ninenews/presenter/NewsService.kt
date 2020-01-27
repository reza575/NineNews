package com.moeiny.reza.ninenews.presenter

import com.moeiny.reza.ninenews.model.entity.News
import com.moeiny.reza.ninenews.model.repository.NewsRepositoryProvider
import com.moeiny.reza.ninenews.utils.NineNewsCallback
import com.moeiny.reza.ninenews.utils.okHttpClientGETBuilder
import com.moeiny.reza.ninenews.utils.retrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class NewsService private constructor() {

     companion object NewsService {
        private var compositeDisposable: CompositeDisposable = CompositeDisposable()

        fun getNewsInfo(block: NineNewsCallback<News, Throwable>) {
            val disposableService: Disposable = NewsRepositoryProvider.provideNewsRepository(retrofit(okHttpClientGETBuilder()))
                .getNewsInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.computation())
                    .subscribe(
                            { result ->
                                block.onSuccess(result = result)
                            },
                            {error ->
                                block.onError(error)
                            },
                            {
                                block.onComplete()
                            }
                    )

            compositeDisposable.add(disposableService)

        }

    }

}