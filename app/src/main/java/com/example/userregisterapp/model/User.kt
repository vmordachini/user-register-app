package com.example.userregisterapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// 1. @Entity: Marca a classe como uma tabela do Room [cite: 157]
@Entity(tableName = "user_table")
data class User(
    // 2. @PrimaryKey: Define a chave primária [cite: 160]
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // 3. @ColumnInfo: Permite renomear a coluna [cite: 163]
    @ColumnInfo(name = "user_name")
    val name: String,

    @ColumnInfo(name = "user_email")
    val email: String,

    @ColumnInfo(name = "user_password")
    val password: String
)