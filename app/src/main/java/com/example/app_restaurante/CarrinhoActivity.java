package com.example.app_restaurante;

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CarrinhoActivity : AppCompatActivity() {

// Lista fictícia de itens no carrinho (substitua com sua lógica real)
private val itensNoCarrinho = listOf("Item 1", "Item 2", "Item 3")

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val listViewItens: ListView = findViewById(R.id.listViewItens)
        val btnPagar: Button = findViewById(R.id.btnPagar)

        // Adaptador para exibir a lista de itens
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itensNoCarrinho)
        listViewItens.adapter = adapter

        // Lógica para o botão de pagamento (substitua conforme necessário)
        btnPagar.setOnClickListener {
        // Adicione a lógica de pagamento aqui
        showToast("Pagamento realizado com sucesso!")
        }
        }

        // Adicione outros métodos ou lógica conforme necessário
        }
