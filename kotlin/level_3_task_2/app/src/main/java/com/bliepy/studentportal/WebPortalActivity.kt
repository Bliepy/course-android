package com.bliepy.studentportal

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_portal)

        val url : String =  intent.getStringExtra("url")

        val actionbar = supportActionBar
        actionbar!!.title = "Portal"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val browser: WebView = findViewById(R.id.webview)

        browser.settings.javaScriptEnabled = true
        browser.settings.loadsImagesAutomatically = true


        browser!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        browser!!.loadUrl(url)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val profileActivityIntent = Intent(this, MainActivity::class.java)
        startActivity(profileActivityIntent)
    }
}

