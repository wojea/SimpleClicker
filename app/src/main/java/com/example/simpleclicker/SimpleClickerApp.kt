package com.example.simpleclicker

import android.app.Application

class SimpleClickerApp: Application(){

    override fun onCreate() {
        super.onCreate()
        UserRoomDatabase.getDatabase(applicationContext).userDao()
    }
}