package com.ymgn.sampo_heatmap

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.storage.StorageManager
import android.util.Log
import android.widget.TextView
import android.view.View
import android.widget.Button
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    private var isStarted = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences(
            "sampo_heatmap", Context.MODE_PRIVATE)
        var str = sharedPref.getString("sampo_heatmap_id", null)
        if (str == null) {
            Log.d("WHEN_NO_UUID", "no uuid found")
            // TODO; generate uuid
            val uuidDefault = StorageManager.UUID_DEFAULT
            with (sharedPref.edit()) {
                putString("sampo_heatmap_id", uuidDefault.toString())
                apply()
            }
            str = uuidDefault.toString()
        } else {
            Log.d("WHEN_UUID_FOUND", "uuid found")
        }

        setContentView(R.layout.activity_main)

        val userIdText = findViewById<TextView>(R.id.id_text)
        userIdText.text = str

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