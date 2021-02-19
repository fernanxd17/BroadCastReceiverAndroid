package com.example.learningbroadcastandroid

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningbroadcastandroid.broadcast.MyBroadcastReceiver

class MainActivity : AppCompatActivity() {

    private val br: BroadcastReceiver = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        registerReceiver(br, filter)
    }

    override fun onPause() {
        //Se anula aquí, si este fue creado en el onResume()
        unregisterReceiver(br)
        super.onPause()
    }

    override fun onDestroy() {
        //Se anula aquí, si el receptor fue creado en el onCreate()
        unregisterReceiver(br)
        super.onDestroy()
    }


}
