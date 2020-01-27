package com.moeiny.reza.ninenews.view

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.moeiny.reza.ninenews.R


class ShowActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        webView = findViewById(R.id.webview)
        val bundle = intent.extras
        var newsUrl = bundle?.getString("newsURL").toString()

        webView.loadUrl(newsUrl);
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

    }







}
