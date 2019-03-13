package com.example.simpleclicker

import android.support.v7.app.AppCompatActivity
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.view.View;
import android.widget.TextView

class MainMenu : AppCompatActivity() {

    lateinit var coordinatorLayout:CoordinatorLayout
    lateinit var s_clicker:Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var b_clicker = findViewById<Button>(R.id.clicker)
        s_clicker = findViewById<Switch>(R.id.switchclicker)
        coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinatorLayout)

        //TODO: jak ustawić początkową wartość na clickerze
        b_clicker.setOnClickListener {
            if(s_clicker.isChecked) b_clicker.setText((b_clicker.text.toString().toInt()+1).toString())
            else showSnackbar()
        }
    }
    fun showSnackbar(){
        val snackbar = Snackbar.make(coordinatorLayout, "The switch is turned off", Snackbar.LENGTH_INDEFINITE)
            .setAction("Turn on", object: View.OnClickListener {
                override fun onClick(v:View) {
                    s_clicker.setChecked(true)
                    val snackbar1 = Snackbar.make(coordinatorLayout, "Switch turned on", Snackbar.LENGTH_SHORT)
                    snackbar1.show()
                }
            })
            .setActionTextColor(Color.YELLOW)
        val snackView = snackbar.getView()
        val textView = snackView.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        textView.setTextColor(Color.BLUE)
        snackbar.show()
    }
}
