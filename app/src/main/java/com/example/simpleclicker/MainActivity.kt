package com.example.simpleclicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var et_username = findViewById<EditText>(R.id.username)
        var et_password = findViewById<EditText>(R.id.password)
        var b_login = findViewById<Button>(R.id.loginB)
        var b_register = findViewById<Button>(R.id.registerB)
        var b_playOffline = findViewById<Button>(R.id.playofflineB)

        b_login.setOnClickListener {
            //login to the game if the password and username match, else show toast about wrong password
            if(et_username.text.toString().equals(et_password.text.toString())) //right now I don't know how to store user data so for the purpose of this laboratory
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

        b_register.setOnClickListener {
            //moves to formula where the user registers
            val intent = Intent(this,RegisterFormula::class.java)
            startActivity(intent)
        }

        b_playOffline.setOnClickListener {
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }
}
