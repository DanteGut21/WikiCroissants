package com.example.wikicroissants

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wikicroissants.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(){

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el listener para el texto "Login"
        binding.loginText.setOnClickListener {
            // Iniciar la actividad MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            // Finalizar esta actividad para evitar que se apile en la pila de actividades
            finish()
        }

        // Configurar el listener para el botón de registro
        binding.loginButton.setOnClickListener {
            // Obtener los valores de los EditText
            val email = binding.email.text.toString()
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.passwordConfirm.text.toString()

            // Validar el formato del email utilizando una expresión regular
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // Mostrar un mensaje de error si el email no es válido
                binding.email.error = "Email inválido"
                return@setOnClickListener
            }

            // Aquí puedes realizar cualquier otra validación necesaria antes de guardar los datos

            // Por ejemplo, verificar si los campos de contraseña coinciden
            if (password != confirmPassword) {
                // Mostrar un mensaje de error si las contraseñas no coinciden
                binding.passwordConfirm.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            }

            // Guardar los datos o realizar cualquier otra acción necesaria
            // Por ejemplo, podrías enviar los datos a un servicio de registro o guardarlos en una base de datos

            // Una vez que los datos se guarden correctamente, puedes iniciar otra actividad o mostrar un mensaje de éxito
            // Por ejemplo, iniciar la actividad de inicio de sesión
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Finalizar esta actividad después de iniciar la siguiente
        }
    }

}//Class RegistroActivity

