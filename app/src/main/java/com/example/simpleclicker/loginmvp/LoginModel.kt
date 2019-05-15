package com.example.simpleclicker.loginmvp

import android.app.Application
import com.example.simpleclicker.SessionManager
import com.example.simpleclicker.db.User
import com.example.simpleclicker.db.UserViewModel

class LoginModel(application: Application):LoginContract.Model {

    val loginViewModel = UserViewModel(application)
    val session = SessionManager(application.applicationContext)

    override fun login(username:String,password:String):Boolean
    {
        val loggedUser: User? = try{loginViewModel.findUser(username)} catch(e:Exception){null}
        if(loggedUser!=null)
        {
            if(password.equals(loggedUser.password))
            {
                session.createLoginSession(username)
                return true
            }
            else
            {
                return false
            }
        }
        else
        {
            return false
        }
    }

}