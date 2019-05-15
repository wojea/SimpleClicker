package com.example.simpleclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simpleclicker.db.User
import com.example.simpleclicker.db.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var session:SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginViewModel: UserViewModel =
            UserViewModel(application)
        session = SessionManager(applicationContext)

        loginB.setOnClickListener {
            val loggedUser: User? = try{loginViewModel.findUser(username.text.toString())} catch(e:Exception){null}
            if(loggedUser!=null)
            {
                if(password.text.toString().equals(loggedUser.password))
                {
                    session.createLoginSession(username.text.toString())
                    val intent = Intent(this,MainMenu::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this@MainActivity, "Wrong username or password!", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
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
}
