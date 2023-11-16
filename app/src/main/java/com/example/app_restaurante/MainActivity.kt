package com.example.app_restaurante


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
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
            foodItems.add(FoodItem("Refrigerante", 8.99f))
            foodItems.add(FoodItem("Salada", 8.99f))

        // Configure o RecyclerView e atribua o adaptador
            val adapter = FoodAdapter(foodItems)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
        }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_back -> {
                // Ação para o item de menu "Voltar"
                onBackPressed()
                return true
            }
            R.id. -> {
                // Lógica para o item 1 do menu
                showToast("Item 1 selecionado")
                return true
            }

            // Adicione mais casos conforme necessário
            else -> return super.onOptionsItemSelected(item)
        }
    }

    // Criar o menu na barra superior
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Função auxiliar para exibir Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
