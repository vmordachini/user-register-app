package com.example.userregisterapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.userregisterapp.database.AppDatabase
import com.example.userregisterapp.model.User
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso ao DAO
    private val userDao = AppDatabase.getDatabase(application).userDao()

    // Desafio Extra: LiveData para observar todos os usuários
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    // Função para inserir um usuário, chamada pela View
    fun insertUser(user: User) {
        // viewModelScope: Garante que a coroutine será cancelada se o ViewModel for destruído
        viewModelScope.launch {
            try {
                userDao.insert(user)
                // Log para verificar a inserção
                Log.i("UserViewModel", "Usuário ${user.name} inserido com sucesso!")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Erro ao inserir usuário: ${e.message}")
            }
        }
    }
}