package com.example.app_restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val foodItems = mutableListOf<FoodItem>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize a lista de produtos

        recyclerView = findViewById(R.id.listaprodutos)
            foodItems.add(FoodItem("Hamburguer", 10.99f))
            foodItems.add(FoodItem("Pizza", 15.99f))
            foodItems.add(FoodItem("Salada", 8.99f))


        // Configure o RecyclerView e atribua o adaptador
        val adapter = FoodAdapter(foodItems)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}


