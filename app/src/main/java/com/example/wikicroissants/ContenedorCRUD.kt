package com.example.wikicroissants

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContenedorCRUD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contenedor_crud)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recuperar la acción desde el Intent
        val action = intent.getStringExtra("ACTION")

        // Crear una nueva instancia del Fragment CRUD con la acción como argumento
        val crudFragment = CRUD().apply {
            arguments = Bundle().apply {
                putString("ACTION", action)
            }
        }
        // Cargar el Fragment CRUD en el contenedor
        supportFragmentManager.beginTransaction()
            .replace(R.id.frgmntCRUD, crudFragment)
            .commit()
    }

}//Class ContenedorCRUD