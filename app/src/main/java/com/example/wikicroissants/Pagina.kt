package com.example.wikicroissants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.add
import androidx.fragment.app.commit

class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)

        //Toolbar
        val tbPagina: androidx.appcompat.widget.Toolbar = findViewById(R.id.tbPagina)
        setSupportActionBar(tbPagina)
        //Toolbar

//        supportActionBar?.title = ""
        supportActionBar?.setDisplayShowTitleEnabled(false)
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_pagina, menu)
        return true
    }//onCreateOptionsMenu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemDelete -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmación")
                    .setMessage("¿Estás seguro de querer eliminar este texto?")
                    .setPositiveButton("Eliminar") { dialog, which ->
                        // Aquí iría el código para eliminar el texto del EditText, por ejemplo:
                        val editText = findViewById<EditText>(R.id.edtPagina)
                        editText.setText("")
                        // Cambiar a Capitulos Fragment en Principal Activity
                        val intent = Intent(this, Principal::class.java)
                        intent.putExtra("fragmentToLoad", "Capitulos") // Indicador para cargar fragmento Capitulos
                        startActivity(intent)
                        finish() // Opcional, si deseas terminar Pagina Activity
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
                true
            }
            R.id.itemSave -> {
                val fragment = supportFragmentManager.findFragmentById(R.id.fcPagina) as Paginas?
                fragment?.let { frag ->
                    AlertDialog.Builder(this)
                        .setTitle("Confirmar Cambios")
                        .setMessage("¿Deseas guardar los cambios realizados?")
                        .setPositiveButton("Guardar") { dialog, which ->
                            frag.saveText()
                        }
                        .setNegativeButton("Cancelar", null)
                        .show()
                }
                Toast.makeText(this,"Guardar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemModify -> {
                val fragment = supportFragmentManager.findFragmentById(R.id.fcPagina) as Paginas?
                fragment?.let {
                    it.unlockEditText()
                }
                Toast.makeText(this,"Modificar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.itemAdd -> {
                val intent = Intent(this, ContenedorCRUD::class.java)
                startActivity(intent)
                Toast.makeText(this,"Agregar Pagina", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }//when
    }//onOptionsItemSelected
    }//Class pagina