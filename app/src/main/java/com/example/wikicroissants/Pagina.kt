package com.example.wikicroissants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)
        val capituloSeleccionado = intent.getStringExtra("EXTRA_CAPITULO")
        // Usa `capituloSeleccionado` según sea necesario
    }//onCreate
}//Class pagina