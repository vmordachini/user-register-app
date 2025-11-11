package com.example.userregisterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.userregisterapp.model.User
import com.example.userregisterapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    // 1. Inicialização do ViewModel
    private val userViewModel: UserViewModel by viewModels()

    // 2. Declaração dos componentes da UI
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonViewList: Button // Desafio Extra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 3. Conexão dos componentes da UI (Binding)
        editTextName = findViewById(R.id.editTextName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonViewList = findViewById(R.id.buttonViewList) // Desafio Extra

        // 4. Configuração do Listener do Botão
        buttonRegister.setOnClickListener {
            registerUser()
        }

        // Listener do Desafio Extra
        buttonViewList.setOnClickListener {
            // Inicia a UserListActivity
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        // 5. Coleta e Validação dos Dados
        val name = editTextName.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        // 6. Criação do Objeto User
        val newUser = User(name = name, email = email, password = password) // [cite: 300, 301]

        // 7. Chamada ao ViewModel para Inserção
        userViewModel.insertUser(newUser)

        // 8. Feedback e Limpeza da UI
        Toast.makeText(this, "Usuário $name cadastrado com sucesso!", Toast.LENGTH_LONG).show() // [cite: 305, 306]
        clearFields() // [cite: 307]
    }

    private fun clearFields() {
        editTextName.text.clear()
        editTextEmail.text.clear()
        editTextPassword.text.clear()
    }
}