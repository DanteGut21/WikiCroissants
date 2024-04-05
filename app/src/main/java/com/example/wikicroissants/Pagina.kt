package com.example.wikicroissants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit

lateinit var btnAnterior: Button
lateinit var btnSiguiente: Button
lateinit var tbPagina: Toolbar

class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)

        //Toolbar
        val tbPagina: androidx.appcompat.widget.Toolbar = findViewById(R.id.tbPagina)
        setSupportActionBar(tbPagina)
        //Toolbar

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
        supportActionBar?.title = ""
    }//onCreate
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_pagina, menu)
        return true
    }//onCreateOptionsMenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemDelete -> {
                Toast.makeText(this,"Eliminar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemModify -> {
                Toast.makeText(this,"Modificar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemAdd -> {
                Toast.makeText(this,"Agregar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }//onOptionsItemSelected
}//Class pagina