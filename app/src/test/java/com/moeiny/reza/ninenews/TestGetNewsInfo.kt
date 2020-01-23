package com.moeiny.reza.ninenews

import com.moeiny.reza.ninenews.model.entity.News
import com.moeiny.reza.ninenews.presenter.NewsService
import com.moeiny.reza.ninenews.utils.NineNewsCallback
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch

class TestGetNewsInfo {
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetNewsInfo() {

        val lock =  CountDownLatch(1)
        lateinit var news: News


        NewsService.getNewsInfo(object : NineNewsCallback<News, Throwable> {

            override fun onSuccess(result: News) {
                Assert.assertNotNull(result)
                news = result
                lock.countDown()
            }

            override fun onError(error: Throwable?) {
                Assert.assertNotNull(error)
                lock.countDown()
            }

            override fun onComplete() {
                print("complete")
                lock.countDown()
            }
        })

        //checking for the test Result
        news.let {
            Assert.assertEquals(it.id, 67184313)
            Assert.assertEquals(it.url, "/content/dam/lists/1/3/z/z/q/x/list.html")
            Assert.assertEquals(it.sponsored, false)
            Assert.assertEquals(it.displayName, "AFR iPad Editor's Choice")
        }
    }
}