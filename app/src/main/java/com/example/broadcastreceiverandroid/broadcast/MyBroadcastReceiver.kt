package com.example.broadcastreceiverandroid.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

private const val TAG = "MyBroadcastReceiver"

class MyBroadcastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("broadcastReceiver", "Recibiendo mensaje")
        StringBuilder().apply {
            append("Action: ${intent?.action}\n")
            append("URI: ${intent?.extras?.get("data")}\n")
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }

}