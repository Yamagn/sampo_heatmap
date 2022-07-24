package com.ymgn.sampo_heatmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    private var isStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton = findViewById<Button>(R.id.start_button)
        val mapButton = findViewById<Button>(R.id.map_button)
        startButton.setOnClickListener {
            if(isStarted) {
                startButton.setText("スタート")
                mapButton.visibility = View.VISIBLE
            } else {
                startButton.setText("終了")
                mapButton.visibility = View.INVISIBLE
            }
            isStarted = !isStarted
        }
    }
}