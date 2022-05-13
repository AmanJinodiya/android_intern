package com.example.android_intern.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.android_intern.R

class recyleAdapter(var list : List<String>,var name : Array<String>,var cru : Array<String>,var map : HashMap<String,Int>) : RecyclerView.Adapter<recyleAdapter.myViewHolder>() {

    lateinit var context:Context
    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.pizza_name)
        var sizes = itemView.findViewById<Spinner>(R.id.sizes)
        var crust = itemView.findViewById<Spinner>(R.id.crust)
        var button = itemView.findViewById<Button>(R.id.Cart)
        var add = itemView.findViewById<ImageView>(R.id.add)
        var dec = itemView.findViewById<ImageView>(R.id.dec)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        context = parent.context
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.name.text = list[position]
        val ada = ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,name)
        val ada2 = ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item,cru)
        holder.sizes.adapter = ada
        holder.crust.adapter = ada2
        var i = 1
        holder.dec.visibility = View.GONE
        holder.add.setOnClickListener{
            holder.button.text = i.toString()
            var name_of_pizza = holder.crust.selectedItem.toString()+" "+holder.sizes.selectedItem.toString()
            map[name_of_pizza] = i
            holder.dec.visibility = View.VISIBLE
            i+=1
        }
        holder.dec.setOnClickListener{
            if(i>0) i-=1
            else i = 0
            holder.button.text = i.toString()
            var name_of_pizza = holder.crust.selectedItem.toString()+" "+holder.sizes.selectedItem.toString()
            map[name_of_pizza] = i

        }


        holder.button.setOnClickListener{
            Log.d("Aman",holder.sizes.selectedItem.toString())
            Log.d("Aman",holder.crust.selectedItem.toString())
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }




}