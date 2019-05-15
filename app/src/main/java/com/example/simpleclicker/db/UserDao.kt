package com.example.simpleclicker.db

import androidx.room.*

@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query(REGISTERQUERY)
    fun register(login:String,pass:String)

    @Query(GETALLUSERSQUERY)
    fun getAllUsers(): List<User>

    @Query(FINDUSERQUERY)
    fun findUser(search: String): User

    @Query(CHECKFORUSERQUERY)
    fun checkForUser(search: String): Int

    @Query(GETUSERSCOREQUERY)
    fun getUserScore(search: String): Int

    @Query(SETUSERSCOREQUERY)
    fun setUserScore(user:String,score: Int)

    @Update
    fun updateUsers(vararg users: User)

    @Delete
    fun delete(user: User)

    companion object
    {
        const val REGISTERQUERY = "INSERT INTO users (username,password,points) VALUES (:login,:pass,0);"
        const val GETALLUSERSQUERY = "SELECT * FROM users"
        const val FINDUSERQUERY = "SELECT * FROM users WHERE username LIKE :search "
        const val CHECKFORUSERQUERY = "SELECT COUNT(1) FROM users WHERE username LIKE :search "
        const val GETUSERSCOREQUERY = "SELECT points FROM users WHERE username LIKE :search "
        const val SETUSERSCOREQUERY = "UPDATE users SET points = :score WHERE username = :user"
    }
}