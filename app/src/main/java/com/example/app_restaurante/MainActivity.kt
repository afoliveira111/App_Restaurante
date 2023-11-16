package com.example.app_restaurante



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<FoodItem>()

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        // Inicialize a lista de produtos
        val foodItems = mutableListOf<FoodItem>()
        foodItems.add(FoodItem("Hamburguer", 10.99f))
        foodItems.add(FoodItem("Pizza", 15.99f))
        foodItems.add(FoodItem("Salada", 8.99f))
        foodItems.add(FoodItem("Refrigerante", 8.99f))
        foodItems.add(FoodItem("Salada", 8.99f))


        recyclerView = findViewById(R.id.listaprodutos)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val adapter = FoodAdapter(foodItems) { clickedItem ->
            addToCart(clickedItem)
        }
        recyclerView.adapter = adapter
    }


    private fun addToCart(foodItem: FoodItem) {
        cartItems.add(foodItem)
        showToast("Produto adicionado ao carrinho")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Isso será acionado quando o botão Voltar for pressionado na barra de aplicativos
                onBackPressed()
                true
            }

            R.id.carrinho -> {
                showToast("Carrinho selecionado")
                // Adicione lógica para ir para a tela do carrinho, se necessário
                true
            }

            R.id.menu_back -> {
                // Navegue de volta para a NextActivity
                val intent = Intent(this, NextActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}

