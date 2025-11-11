package com.example.userregisterapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.userregisterapp.model.User

@Dao // [cite: 180]
interface UserDao {

    // 2. @Insert: Método para inserir
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    // Desafio Extra: Método para ler todos os usuários
    @Query("SELECT * FROM user_table ORDER BY user_name ASC")
    fun getAllUsers(): LiveData<List<User>>
}