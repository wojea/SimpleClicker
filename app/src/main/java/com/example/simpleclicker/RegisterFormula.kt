package com.example.simpleclicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

        b_register1.setOnClickListener {
            //if passwords match shows toast that user is registered else shows other toast
            if(et_pass1.text.toString().equals(et_pass2.text.toString())) Toast.makeText(this@RegisterFormula, "Registered successfully", Toast.LENGTH_LONG).show()
            else Toast.makeText(this@RegisterFormula, "Passwords do not match", Toast.LENGTH_LONG).show()
        }

    }
}
