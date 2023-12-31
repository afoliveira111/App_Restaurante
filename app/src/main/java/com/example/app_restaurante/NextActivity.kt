package com.example.app_restaurante

import androidx.appcompat.widget.Toolbar
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class NextActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<FoodItem>() // Mantenha uma lista dos itens no carrinho


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        // Configurar a barra de navegação
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar a lista de produtos
        val foodItems =
            mutableListOf<FoodItem>() // Certifique-se de inicializar corretamente a lista
        foodItems.add(FoodItem("Hamburguer", 10.99f))
        foodItems.add(FoodItem("Pizza", 15.99f))
        foodItems.add(FoodItem("Salada", 8.99f))
        foodItems.add(FoodItem("Refrigerante", 8.99f))
        foodItems.add(FoodItem("Salada", 8.99f))


        val recyclerView: RecyclerView = findViewById(R.id.listaprodutos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = FoodAdapter(foodItems) { clickedItem ->
            addToCart(clickedItem)
        }
        recyclerView.adapter = adapter

        // Configurar o BottomNavigationView
        val btnInicio: BottomNavigationView = findViewById(R.id.btninício)
        btnInicio.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_back -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.carrinho -> {
                    // Passa a lista de itens no carrinho para a CarrinhoActivity
                    val intent = Intent(this, CarrinhoActivity::class.java)
                    intent.putExtra("cartItems", ArrayList(cartItems))
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun addToCart(foodItem: FoodItem) {
        cartItems.add(foodItem)
        showToast("Item adicionado ao carrinho")
    }

    private fun showCartItems() {
        // Lógica para exibir os itens no carrinho
        val cartItemsString = cartItems.joinToString(separator = "\n") { it.name }
        showToast("Itens no Carrinho:\n$cartItemsString")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}






