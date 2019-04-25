package com.example.simpleclicker

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout


class Settings : AppCompatActivity(), Appearance.OnFragmentInteractionListener, Language.OnFragmentInteractionListener, MyAccount.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri){}

    private lateinit var viewpager: androidx.viewpager.widget.ViewPager
    private lateinit var tabs: TabLayout

    //TODO: implement settings
    lateinit var adapter:SettingsAdapter
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        initViews()
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        adapter = SettingsAdapter(supportFragmentManager)
        adapter!!.addFragment(MyAccount(),"My Account")
        adapter!!.addFragment(Language(),"Language")
        adapter!!.addFragment(Appearance(),"Appearance")
        viewpager.adapter=adapter
        tabs.setupWithViewPager(viewpager)
        //setupViewPager()
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.viewpager)
    }
/*
    private fun setupViewPager() {

        val adapter = SettingsAdapter(getSupportFragmentManager())

        var firstFragmet: MyAccount = MyAccount.newInstance("1","2")
        var secondFragmet: Language = Language.newInstance("1","2")
        var thirdFragmet: Appearance = Appearance.newInstance("1","2")

        //TODO: hard-coded strings -> res/values/strings
        adapter.addFragment(firstFragmet, "My Account")
        adapter.addFragment(secondFragmet, "Language")
        adapter.addFragment(thirdFragmet, "Appearance")

        viewpager!!.adapter = adapter

        tabs!!.setupWithViewPager(viewpager)

    }
    */
}
