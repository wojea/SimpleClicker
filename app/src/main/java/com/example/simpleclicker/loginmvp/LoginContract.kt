package com.example.simpleclicker.loginmvp

import android.app.Application

interface LoginContract {

    interface View
    {
        fun getApp():Application
        fun initView()
    }

    interface Presenter
    {
        fun login(username:String, password:String):Boolean
    }

    interface Model
    {
        fun login(username:String, password:String):Boolean
    }

}