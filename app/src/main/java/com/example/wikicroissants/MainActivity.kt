package com.example.wikicroissants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wikicroissants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username : EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener(View.OnClickListener {

        if (binding.username.text.toString() == "user" && binding.password.text.toString() == "User123") {
            // Muestra un mensaje de login exitoso
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

            // Crea un Intent para iniciar la activity
            val intent = Intent(this, Principal::class.java)

            // Inicia la actividad
            startActivity(intent)

            // Opcional: Finaliza la actividad actual si no quieres que el usuario regrese a ella presionando el botón atrás
            finish()
            } else {
            // Muestra un mensaje de fallo en el login
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })//setOnClickListener
        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java) )
        }
    }
}//Class Main