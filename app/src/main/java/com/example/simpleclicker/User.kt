package com.example.simpleclicker

import androidx.room.*

@Fts4
@Entity(tableName = "users")
data class User(
    @PrimaryKey var id: Int,
    var username: String?,
    var password: String?,
    var points: Int
)
