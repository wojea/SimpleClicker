package com.example.simpleclicker

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simpleclicker.loginmvp.LoginContract
import com.example.simpleclicker.loginmvp.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View{

    lateinit var session:SessionManager
    lateinit var presenter: LoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this)

    }

    override fun initView() {
        loginB.setOnClickListener {
            if(presenter.login(username.text.toString(),password.text.toString())){
                val intent = Intent(this,MainMenu::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@MainActivity, "Wrong username or password!", Toast.LENGTH_LONG).show()
            }
        }
        registerB.setOnClickListener {
            //moves to formula where the user registers
            val intent = Intent(this,RegisterFormula::class.java)
            startActivity(intent)
        }

        playofflineB.setOnClickListener {
            session.createLoginSession("login")
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }

    override fun getApp(): Application {
        return this.application
    }
}
