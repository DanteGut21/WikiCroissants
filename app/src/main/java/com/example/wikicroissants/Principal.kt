package com.example.wikicroissants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class Principal : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        supportFragmentManager.commit{
            setReorderingAllowed(true)
//            add<Estanteria>(R.id.fragmentContainer)
            add<Libros>(R.id.fragmentContainer)
        }
    }
}