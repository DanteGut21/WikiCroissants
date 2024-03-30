package com.example.wikicroissants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class Pagina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina)
        supportFragmentManager.commit{
            setReorderingAllowed(true)
            add<Paginas>(R.id.fcPagina)
        }
    }//onCreate
}//Class pagina