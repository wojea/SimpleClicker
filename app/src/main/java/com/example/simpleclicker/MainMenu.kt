package com.example.simpleclicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var b_clicker = findViewById<Button>(R.id.clicker)

        //TODO: jak ustawić początkową wartość na clickerze
        b_clicker.setOnClickListener {
            b_clicker.setText((b_clicker.text.toString().toInt()+1).toString())
        }
    }
}
