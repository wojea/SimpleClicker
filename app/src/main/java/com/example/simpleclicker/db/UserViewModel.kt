package com.example.simpleclicker.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: UserRepository
    val allUsers: List<User>

    init {
        val database = UserRoomDatabase.getDatabase(application)
        repository = UserRepository(database.userDao())
        allUsers = repository.allUsers
    }

    fun findUser(username:String): User = runBlocking()
    {
        val defferedUser = async {repository.findUser(username)}
        runBlocking { defferedUser.await() }
    }

    fun checkForUser(username:String):Int = runBlocking()
    {
        val defferedVal = async {repository.checkForUser(username)}
        runBlocking { defferedVal.await() }
    }

    fun insert(user: User) = scope.launch(Dispatchers.IO) {
        repository.insert(user)
    }

    fun getUserScore(search: String): Int = runBlocking() {
        var userScore:Int = 0
        val defferedScore = async { repository.getUserScore(search) }
        runBlocking { userScore=defferedScore.await() }
        userScore
    }

    fun setUserScore(user:String,score: Int) = scope.launch(Dispatchers.IO){
        repository.setUserScore(user,score)
    }

    fun registerUser(login:String, password:String) = scope.launch(Dispatchers.IO) {
        repository.register(login,password)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}