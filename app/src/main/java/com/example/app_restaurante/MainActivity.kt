package com.example.app_restaurante


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val foodItems = mutableListOf<FoodItem>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            finish()
        }


        // Inicialize a lista de produtos
            recyclerView = findViewById(R.id.listaprodutos)
            foodItems.add(FoodItem("Hamburguer", 10.99f))
            foodItems.add(FoodItem("Pizza", 15.99f))
            foodItems.add(FoodItem("Salada", 8.99f))
            foodItems.add(FoodItem("Refrigerante", 8.99f))
            foodItems.add(FoodItem("Salada", 8.99f))

        // Configure o RecyclerView e atribua o adaptador
            val adapter = FoodAdapter(foodItems)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
        }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Isso executa a ação de voltar
                return true
            }
        }
     return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}