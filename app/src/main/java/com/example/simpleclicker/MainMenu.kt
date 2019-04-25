package com.example.simpleclicker

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Switch
import android.view.View;
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {

    lateinit var coordinatorLayout: androidx.coordinatorlayout.widget.CoordinatorLayout
    lateinit var s_clicker:Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var b_clicker = findViewById<Button>(R.id.clicker)
        var b_check = findViewById<Button>(R.id.check)
        s_clicker = findViewById<Switch>(R.id.switchclicker)
        coordinatorLayout = findViewById<androidx.coordinatorlayout.widget.CoordinatorLayout>(R.id.coordinatorLayout)

        Picasso.get().load("https://i.imgur.com/vVZeeU4.png").into(demonstration)



        //TODO: jak ustawić początkową wartość na clickerze
        b_clicker.setOnClickListener {
            if (s_clicker.isChecked) b_clicker.setText((b_clicker.text.toString().toInt() + 1).toString())
            else showSnackbar()
        }

        b_check.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("I'm a gnome and you've been GNOOMED!!!")
                .setCancelable(false)
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })
            val alert = dialogBuilder.create()
            alert.setTitle("April fools")
            alert.show()
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
        val textView = snackView.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(Color.BLUE)
        snackbar.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.stats){
            val intent = Intent(this,Stats::class.java)
            startActivity(intent)
            //specjalnie nie daję tu finish() bo chcę mieć dalej w tle tę aktywność
        }
        if(item?.itemId == R.id.settings){
            val intent = Intent(this,Settings::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
