package com.example.android_intern

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_intern.Adapters.billAdapter

class Bill : AppCompatActivity() {
    var map = HashMap<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)
        var recylce = findViewById<RecyclerView>(R.id.recyclerView)

        map.put("Hand-Tossed Regular",235)
        map.put("Hand-Tossed Medium",265)
        map.put("Hand-Tossed Large",295)
        map.put("Cheese-Burst Regular",235)
        map.put("Cheese-Burst Medium",295)
        map.put("Cheese-Burst Large",335)

        val list = intent.getSerializableExtra("details") as ArrayList<Pair<String,Int>>
        recylce.adapter = billAdapter(list,map)
        recylce.layoutManager = LinearLayoutManager(this)
        var z = 0
        for(i in list)
        {
            z+= (i.second*(map[i.first]!!))
        }

        var total = findViewById<TextView>(R.id.textView7)
        total.text = z.toString()







    }
}