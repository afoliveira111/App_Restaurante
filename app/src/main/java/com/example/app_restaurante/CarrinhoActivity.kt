package com.example.app_restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class CarrinhoActivity : AppCompatActivity() {

     private val cartItems = mutableListOf<FoodItem>() // Sua lista de itens no carrinho

    // ... outros métodos e propriedades ...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        // Recebe a lista de itens do carrinho da Intent
        val itensNoCarrinho = intent.getSerializableExtra("cartItems") as? ArrayList<FoodItem>

        // Verifica se a lista não é nula e adiciona os itens ao carrinho
        if (itensNoCarrinho != null) {
            cartItems.addAll(itensNoCarrinho)
        }

        val listViewItens: ListView = findViewById(R.id.listViewItens)
        val btnPagar: Button = findViewById(R.id.btnPagar)

        // Adaptador para exibir a lista de itens
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cartItems.map { it.name })
        listViewItens.adapter = adapter

        // Lógica para o botão de pagamento (substitua conforme necessário)
        btnPagar.setOnClickListener {
            // Adicione a lógica de pagamento aqui
            showToast("Pagamento realizado com sucesso!")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }


    // Adicione outros métodos ou lógica conforme necessário
}
