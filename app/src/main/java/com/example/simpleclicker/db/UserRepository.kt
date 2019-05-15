package com.example.simpleclicker.db
import androidx.annotation.WorkerThread
import kotlinx.coroutines.*

class UserRepository(private val userDao: UserDao) {
    val allUsers: List<User> = runBlocking() {
        var users:List<User> = emptyList()
        val defferedUsers = async { getAllUsers() }
        runBlocking { users=defferedUsers.await() }
        users
    }

    @WorkerThread
    suspend fun getAllUsers():List<User>
    {
        return userDao.getAllUsers()
    }

    @WorkerThread
    suspend fun findUser(search:String): User
    {
        return userDao.findUser(search)
    }

    @WorkerThread
    suspend fun checkForUser(search: String): Int
    {
        return userDao.checkForUser(search)
    }

    @WorkerThread
    suspend fun getUserScore(search: String): Int
    {
        return userDao.getUserScore(search)
    }

    @WorkerThread
    suspend fun setUserScore(user:String,score: Int)
    {
        userDao.setUserScore(user,score)
    }

    @WorkerThread
    suspend fun register(login:String,password:String)
    {
        userDao.register(login,password)
    }

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}