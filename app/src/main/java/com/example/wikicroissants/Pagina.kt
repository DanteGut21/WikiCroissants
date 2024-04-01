package com.example.wikicroissants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit

lateinit var btnAnterior: Button
lateinit var btnSiguiente: Button

class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<Paginas>(R.id.fcPagina)
        }//supportFragmentManager
        val btnAnterior: Button = findViewById(R.id.btnAnterior)
        val btnSiguiente: Button = findViewById(R.id.btnSiguiente)

        btnAnterior.setOnClickListener{
            Toast.makeText(this, "Anterior", Toast.LENGTH_SHORT).show()
        }

        btnSiguiente.setOnClickListener{
            Toast.makeText(this, "Siguiente", Toast.LENGTH_SHORT).show()
        }
    }//onCreate
}//Class pagina