package com.example.simpleclicker

import android.content.Context
import android.content.SharedPreferences

class SessionManager
{
    lateinit var pref:SharedPreferences
    lateinit var editor:SharedPreferences.Editor
    lateinit var con:Context

    constructor(con: Context)
    {
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    companion object
    {
        val PREF_NAME = "CurrentUser"
        val IS_LOGGED = "isLoggedIn"
        val KEY_LOGIN = "login"
    }

    fun createLoginSession(login:String)
    {
        editor.putBoolean(IS_LOGGED,true)
        editor.putString(KEY_LOGIN,login)
        editor.commit()
    }

    fun getUserLogin():String
    {
        return pref.getString(KEY_LOGIN,"login")
    }


    fun logout()
    {
        editor.clear()
        editor.commit()
    }
}