package com.example.simpleclicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.support.v4.content.ContextCompat.startActivity
import android.content.ActivityNotFoundException
import android.R.id
import android.net.Uri
import kotlinx.android.synthetic.main.activity_register_formula.*


class RegisterFormula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_formula)

        var et_pass2 = findViewById<EditText>(R.id.password2)
        var b_register1 = findViewById<Button>(R.id.register1B)
        var b_return1 = findViewById<Button>(R.id.return1B)

        val registerViewModel:UserViewModel = UserViewModel(application)

        b_return1.setOnClickListener {
            //return to login activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            //getString(R.strings. id stringa
            finish()
        }

        b_return1.setOnLongClickListener {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:gLn3BOokmDU"))
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/gLn3BOokmDU?t=9")
            )
            try {
                Toast.makeText(this@RegisterFormula, "Putin wants to know your location", Toast.LENGTH_LONG).show()
                startActivity(appIntent)
                true
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this@RegisterFormula, "Putin wants to know your location", Toast.LENGTH_LONG).show()
                startActivity(webIntent)
                true
            }

        }

        b_register1.setOnClickListener {
            if(password1.text.toString().equals(et_pass2.text.toString())&&password1.text.toString()!=""&&username1.text.toString()!="")
            {
                registerViewModel.registerUser(username1.text.toString(),password1.text.toString())
            }else{
                Toast.makeText(this@RegisterFormula, "Passwords must match, username and passwords can't be empty", Toast.LENGTH_LONG).show()
            }

            /*
            if(password1.text.toString().equals(et_pass2.text.toString())) Toast.makeText(this@RegisterFormula, "Registered successfully", Toast.LENGTH_LONG).show()
            else Toast.makeText(this@RegisterFormula, "Passwords do not match", Toast.LENGTH_LONG).show()
            */
        }

        b_register1.setOnLongClickListener {
            val intent = Intent(this,SupriseActivity::class.java)
            startActivity(intent)
            true}
    }
}
