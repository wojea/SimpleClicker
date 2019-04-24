package com.example.simpleclicker

import android.content.Context

class Preference(context : Context)
{
    val PREFERENCE = "Preference"
    val preference = context.getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
}