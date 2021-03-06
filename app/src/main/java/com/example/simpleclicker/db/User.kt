package com.example.simpleclicker.db

import androidx.room.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey var id: Int,
    var username: String?,
    var password: String?,
    var points: Int
)
