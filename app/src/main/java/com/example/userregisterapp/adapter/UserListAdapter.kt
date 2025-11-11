package com.example.userregisterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userregisterapp.R
import com.example.userregisterapp.model.User

class UserListAdapter : ListAdapter<User, UserListAdapter.UserViewHolder>(UsersComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name, current.email)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.textViewItemName)
        private val emailItemView: TextView = itemView.findViewById(R.id.textViewItemEmail)

        fun bind(name: String?, email: String?) {
            nameItemView.text = name
            emailItemView.text = email
        }
    }

    class UsersComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}