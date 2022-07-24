package com.ymgn.sampo_heatmap

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.storage.StorageManager
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
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
    }
}