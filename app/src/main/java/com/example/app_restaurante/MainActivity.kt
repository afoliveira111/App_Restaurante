package com.example.app_restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Crie uma lista de itens
        val foodItems = listOf(
            FoodItem("Hambúrguer", 10.99f),
            FoodItem("Pizza", 15.99f),
            FoodItem("Salada", 8.99f)
        )

        // Configure o RecyclerView e atribua o adaptador
        val adapter = FoodAdapter(foodItems)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}


