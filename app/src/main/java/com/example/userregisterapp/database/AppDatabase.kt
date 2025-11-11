package com.example.userregisterapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.userregisterapp.model.User

// 1. @Database: Lista as entidades e define a versão
@Database(entities = [User::class], version = 1, exportSchema = false) // [cite: 208]
abstract class AppDatabase : RoomDatabase() {

    // 2. O Room precisa saber como acessar o DAO
    abstract fun userDao(): UserDao

    // 3. Companion Object para criar o Singleton
    companion object {
        @Volatile // [cite: 215]
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Se a instância for nula, cria uma nova
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}