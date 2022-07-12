package com.example.mygymprogram

import android.util.Log
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.create
import okio.IOException

// convert from java to kotlin by myself
// original: https://square.github.io/okhttp/ (Post to a Server)
class PostExample(private val url: String, private val json: String): Thread(){
    private val JSON: MediaType = "application/json; charset=utf-8".toMediaType()
    private val client = OkHttpClient()
    private var response = "nothing"

    override fun run() {
        response = post(url, json)
        Log.i("###", response)
    }

    @Throws(IOException::class)
    private fun post(url: String, json: String): String {
        val body: RequestBody = create(JSON, json)
        val request: Request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        client.newCall(request).execute().use { response -> return response.body!!.string() }
    }
}