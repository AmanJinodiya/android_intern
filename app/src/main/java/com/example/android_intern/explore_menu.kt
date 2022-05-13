package com.example.android_intern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_intern.Adapters.recyleAdapter





class explore_menu : AppCompatActivity() {

    var map = HashMap<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_menu)
        val list = listOf<String>("cheeze burst","cheese burst","perry perry veg")
        var recycl = findViewById<RecyclerView>(R.id.reycle)
        var n : Array<String> = resources.getStringArray(R.array.sizes)

        var m : Array<String> = resources.getStringArray(R.array.crust)

        var final_button = findViewById<Button>(R.id.final_but)
        var bill_item  = ArrayList<Pair<String,Int>>()

        map.put("Hand-Tossed Regular",0)
        map.put("Hand-Tossed Medium",0)
        map.put("Hand-Tossed Large",0)
        map.put("Cheese-Burst Regular",0)
        map.put("Cheese-Burst Medium",0)
        map.put("Cheese-Burst Large",0)


        val adap = recyleAdapter(list,n,m,map)
        recycl.adapter = adap
        recycl.layoutManager = LinearLayoutManager(this)

        final_button.setOnClickListener{
            map.forEach{
                Log.d("Aman",it.key+" "+it.value)
                if(it.value >= 1)
                {
                    bill_item.add(Pair(it.key,it.value))
                }

            }
            var c = ArrayList<String>()
            c.add("aman")
            c.add("nman")
            startActivity(Intent(this,Bill::class.java).putExtra("details",bill_item))
        }

    }
}