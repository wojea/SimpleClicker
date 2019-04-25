package com.example.simpleclicker
import android.content.Context
import androidx.room.*


@Database(entities = [User::class], version = 1)
public abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "Word_database"
                ).allowMainThreadQueries().build()
                    INSTANCE = instance
                instance
            }
        }
    }
}