package com.example.simpleclicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loginB.setOnClickListener {
            //login to the game if the password and username match, else show toast about wrong password
            if(username.text.toString().equals(password.text.toString())) //right now I don't know how to store user data so for the purpose of this laboratory
            // I just check whether the password and the username are the same instead
            {
                val intent = Intent(this,MainMenu::class.java)
                startActivity(intent)
            }
            else
            {
                val login_mismatch = "Login and password don't match"
                Toast.makeText(this@MainActivity, login_mismatch, Toast.LENGTH_LONG).show()
                //TODO: jak pytac w roznych jezykach?
            }
            //TODO: formularz logowania (taki prawdziwy)
        }

        registerB.setOnClickListener {
            //moves to formula where the user registers
            val intent = Intent(this,RegisterFormula::class.java)
            startActivity(intent)
        }

        playofflineB.setOnClickListener {
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }
}
