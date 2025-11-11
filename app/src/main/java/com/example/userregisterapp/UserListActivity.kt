package com.example.userregisterapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userregisterapp.adapter.UserListAdapter
import com.example.userregisterapp.viewmodel.UserViewModel
import com.google.android.material.appbar.MaterialToolbar

class UserListActivity : AppCompatActivity() {

    // Inicializa o ViewModel
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarUserList)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Simplesmente fecha esta activity
        }

        // Configura o RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewUsers)
        val adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observa o LiveData do ViewModel
        userViewModel.allUsers.observe(this) { users ->
            // Atualiza a lista no adapter
            users?.let { adapter.submitList(it) }
        }
    }

    /*override fun onSupportNavigateUp(): Boolean {
        // Esta função é chamada quando a seta "Up" é clicada
        onBackPressedDispatcher.onBackPressed() // Simplesmente fecha esta activity
        return true
    }*/
}