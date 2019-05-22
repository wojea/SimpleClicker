package com.example.simpleclicker.loginmvp

import android.app.Application
import com.example.simpleclicker.SessionManager
import com.example.simpleclicker.db.User
import com.example.simpleclicker.db.UserViewModel

class LoginModel(application: Application):LoginContract.Model {

    val loginViewModel = UserViewModel(application)
    //injection
    val session = SessionManager(application.applicationContext)

    override fun login(username:String,password:String):Boolean
    {
        val loggedUser: User? = try{loginViewModel.findUser(username)} catch(e:Exception){null}
        return if(loggedUser!=null) {
            if(password == loggedUser.password) {
                session.createLoginSession(username)
                true
            } else {
                false
            }
        } else {
            false
        }
    }

}