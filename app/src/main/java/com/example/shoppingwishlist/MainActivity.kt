package com.example.shoppingwishlist

import ItemAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemFetcher = ItemFetcher()

        // link objects from xml
        val button = findViewById<Button>(R.id.button)
        val inputName = findViewById<TextView>(R.id.inputName)
        val inputPrice = findViewById<TextView>(R.id.inputPrice)
        val inputURL = findViewById<TextView>(R.id.inputUrl)

        button.setOnClickListener {
            itemFetcher.addItem(
                inputName.text.toString(),
                inputPrice.text.toString(),
                inputURL.text.toString()
            )

            // RV display
            val rv = findViewById<RecyclerView>(R.id.recyclerView)
            items = itemFetcher.getItems()
            val adapter = ItemAdapter(items)
            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)
        }

    }
}