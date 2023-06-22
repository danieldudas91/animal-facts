package com.example.animalfacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AnimalViewHolder(itemView: View,
                       private val nameTextView: TextView =
                           itemView.findViewById(R.id.textView)) : RecyclerView.ViewHolder(itemView) {
    fun bind(name : String){
        nameTextView.text = name
    }

    companion object{
        fun create(parent: ViewGroup): AnimalViewHolder{
            val view: View = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
            return AnimalViewHolder(view)
        }
    }
}