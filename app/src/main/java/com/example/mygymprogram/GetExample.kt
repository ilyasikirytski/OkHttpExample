package com.example.mygymprogram

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException


class GetExample(private var url: String) : Thread() {

    private var response: String = "nothing"

    override fun run() {
        response = run(url)
        Log.i("MSG", response)
    }

// this is convert from java to kotlin by myself
//
//    private fun run2(url: String): String {
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(url)
//            .build()
//        val response = client.newCall(request).execute()
//        return response.body?.string().toString();
//    }

// auto convert
    private var client = OkHttpClient()

    @Throws(IOException::class)
    private fun run(url: String): String {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().use { response -> return response.body!!.string() }
    }
}
