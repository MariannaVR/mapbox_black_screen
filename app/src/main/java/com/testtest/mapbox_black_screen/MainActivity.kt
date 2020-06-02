package com.testtest.mapbox_black_screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        workBtn.setOnClickListener {
            MapActivity.startActivityWithoutOptions(this)
        }

        notWorkBtn.setOnClickListener {
            MapActivity.startActivityWithOptions(this)
        }
    }


}