package com.example.data

import android.app.Service
import android.content.Intent
import android.os.IBinder

class SignInService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    fun validateUser(userName: String, password: String): Boolean {
        if (userName.isNotEmpty() && userName.trim().length < 12 && password.isNotEmpty()
            && password.trim().length < 12
        )
            return true
        return false
    }

}