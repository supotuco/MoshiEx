package com.example.moshiex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {

    data class Name(@Json(name = "id") val name: String)

    private val json = """{"id":"name"}"""

    private lateinit var moshi: Moshi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonView = findViewById<TextView>(R.id.jsonTextView)
        val stringView = findViewById<TextView>(R.id.stringTextView)

        moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        val name = moshi.adapter(Name::class.java).fromJson(json)

        jsonView.text = json
        stringView.text = name.toString()
    }
}
