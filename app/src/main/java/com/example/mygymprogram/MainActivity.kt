package com.example.mygymprogram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Get a URL
        val path = "https://raw.github.com/square/okhttp/master/README.md"
        val getExample = GetExample(path)
        getExample.start()

// POST to a Server
        val json = bowlingJson("Jesse", "Jake")
        val postExample = PostExample("http://www.roundsapp.com/post", json)
        postExample.start()
    }

    private fun bowlingJson(player1: String, player2: String): String {
        return ("{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}")
    }
}