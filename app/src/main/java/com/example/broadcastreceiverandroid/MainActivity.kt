package com.example.broadcastreceiverandroid

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastreceiverandroid.broadcast.MyBroadcastReceiver
import com.example.learningbroadcastandroid.R

class MainActivity : AppCompatActivity() {

    private val br: BroadcastReceiver = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        registerReceiver(br, intentFilter)
    }

    override fun onDestroy() {
        //Se anula aquí, a fin de que no salga del contexto de la activity
        unregisterReceiver(br)
        super.onDestroy()
    }


}
