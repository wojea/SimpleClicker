package com.example.simpleclicker

import android.app.Application
import com.example.simpleclicker.db.UserRoomDatabase
import com.facebook.stetho.Stetho

class SimpleClickerApp: Application(){

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        UserRoomDatabase.getDatabase(applicationContext).userDao()
    }
}