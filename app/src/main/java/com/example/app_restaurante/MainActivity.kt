package com.example.app_restaurante



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {

    private val foodItems = mutableListOf<FoodItem>()
    private val cartItems = mutableListOf<FoodItem>()

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
        val adapter = FoodAdapter(foodItems) { clickedItem ->
            addToCart(clickedItem)
        }
        recyclerView.adapter = adapter

    }

    private fun addToCart(foodItem: FoodItem) {
        cartItems.add(foodItem)
        // Adicione qualquer lógica adicional que você precise ao adicionar um item ao carrinho
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_back -> {
                // Ação para o item de menu "Voltar"
                onBackPressed()
                return true
            }
            R.id.carrinho -> {
                // Lógica para o item "Carrinho"
                showToast("Carrinho selecionado")
                // Adicione aqui a lógica para adicionar itens ao carrinho
                return true
            }
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
