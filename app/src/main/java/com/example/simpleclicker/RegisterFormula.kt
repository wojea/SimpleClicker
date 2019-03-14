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


class RegisterFormula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_formula)

        var et_pass1 = findViewById<EditText>(R.id.password1)
        var et_pass2 = findViewById<EditText>(R.id.password2)
        var b_register1 = findViewById<Button>(R.id.register1B)
        var b_return1 = findViewById<Button>(R.id.return1B)

        b_return1.setOnClickListener {
            //return to login activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        b_return1.setOnLongClickListener {
            val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:gLn3BOokmDU"))
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://youtu.be/gLn3BOokmDU?t=9")
            )
            try {
                Toast.makeText(this@RegisterFormula, "Putin wants to know your location", Toast.LENGTH_LONG).show()
                this.startActivity(appIntent)
                true
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this@RegisterFormula, "Putin wants to know your location", Toast.LENGTH_LONG).show()
                this.startActivity(webIntent)
                true
            }

        }

        b_register1.setOnClickListener {
            //if passwords match shows toast that user is registered else shows other toast
            if(et_pass1.text.toString().equals(et_pass2.text.toString())) Toast.makeText(this@RegisterFormula, "Registered successfully", Toast.LENGTH_LONG).show()
            else Toast.makeText(this@RegisterFormula, "Passwords do not match", Toast.LENGTH_LONG).show()
        }

        b_register1.setOnLongClickListener {
            val intent = Intent(this,SupriseActivity::class.java)
            startActivity(intent)
            true}
    }
}