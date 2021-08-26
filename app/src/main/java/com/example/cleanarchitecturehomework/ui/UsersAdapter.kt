package com.example.cleanarchitecturehomework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturehomework.R
import com.example.cleanarchitecturehomework.model.UserModel
import java.text.SimpleDateFormat
import java.util.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

   private val usersModelList = mutableListOf<UserModel>()

    fun setList(userView: List<UserModel>) {
        usersModelList.clear()
        usersModelList.addAll(userView)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = usersModelList[position]

        holder.tvName.text = currentItem.name
        holder.tvSurname.text = currentItem.surname

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date().time)

        holder.tvDate.text = currentDate
    }

    override fun getItemCount(): Int {
        return usersModelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.name)
        val tvSurname: TextView = itemView.findViewById(R.id.surname)
        val tvDate: TextView = itemView.findViewById(R.id.date)
    }

}