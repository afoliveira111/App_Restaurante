package com.example.app_restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
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

        val btnFinalizarPagamento = findViewById<Button>(R.id.btnFinalizarPagamento)
        btnFinalizarPagamento.setOnClickListener {
            // Implemente a lógica para a tela de finalização de pagamento

            setContentView(R.layout.activity_next)


            val toolBar = findViewById<LinearLayout>(R.id.toolbar)

            toolBar.setOnClickListener {
                if (isMainActivity) {
                    // Inicie a próxima atividade (substitua `NextActivity::class.java` pelo nome da sua próxima atividade)
                    val intent = Intent(this, NextActivity::class.java)
                    startActivity(intent)
                    finish() // Opcional: encerre a tela inicial após a abertura da próxima atividade
                } else {
                    // Crie uma intenção para voltar à MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Opcional: encerre a tela atual após a abertura da MainActivity
                }
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
    }