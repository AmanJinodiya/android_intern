package com.example.android_intern.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_intern.R

class billAdapter(val list : ArrayList<Pair<String,Int>>,var map : HashMap<String,Int>) : RecyclerView.Adapter<billAdapter.myViewHolder>() {



    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var count = itemView.findViewById<TextView>(R.id.no_of_pizza)
        var name = itemView.findViewById<TextView>(R.id.name)
        var price = itemView.findViewById<TextView>(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.order_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.count.text = list[position].second.toString()
        holder.name.text = list[position].first
        holder.price.text = (list[position].second * map[list[position].first]!!).toString()
//
    }

    override fun getItemCount(): Int {
        return list.size
    }

}