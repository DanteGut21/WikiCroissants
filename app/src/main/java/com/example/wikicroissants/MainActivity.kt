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
import com.google.zxing.integration.android.IntentIntegrator
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    lateinit var username : EditText
//    lateinit var password: EditText
//    lateinit var loginButton: Button

//Implementacion QR
//    private lateinit var codigo: EditText
//    private lateinit var descripcion: EditText
//    private lateinit var btnScanQR: Button
//    private lateinit var btnCapturar: Button
//    private lateinit var btnLimpiar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener(View.OnClickListener {
        if (binding.username.text.toString() == "user" && binding.password.text.toString() == "User123") {
            Toast.makeText(this, "Bienvienido Usuario!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
            finish()
            } else {
            Toast.makeText(this, "Error en la confirmacion de los datos!", Toast.LENGTH_SHORT).show()
            }
        })//setOnClickListener
        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java) )
        }

        //QR
        binding.btnScanQR.setOnClickListener{ escanearCodigo()}

        // Eventos
//        btnScanQR.setOnClickListener { escanearCodigo() }
//        btnCapturar.setOnClickListener {
//            if (codigo.text.toString().isNotEmpty() &&
//                descripcion.text.toString().isNotEmpty()) {
//                Toast.makeText(this, "Datos capturados",
//                    Toast.LENGTH_LONG).show()
//            }
//        }
//        btnLimpiar.setOnClickListener { limpiar() }
    }//onCreate

    private fun escanearCodigo() {
        val intentIntegrator = IntentIntegrator(this).apply {
            setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            setPrompt("Lector de códigos")
            setCameraId(0)
            setBeepEnabled(true)
            setBarcodeImageEnabled(true)
        }
        intentIntegrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        intentResult?.contents?.let { contents ->
            Toast.makeText(this, "Código leído: $contents", Toast.LENGTH_SHORT).show()
            if (contents == "070847036043") {
                val newIntent = Intent(this, Principal::class.java)
                startActivity(newIntent)
            }
        } ?: run {
            Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show()
        }
    }

//
//    private fun escanearCodigo() {
//        // Instancia para leer códigos
//        val intentIntegrator = IntentIntegrator(this@MainActivity)
//        // Definir el tipo de codigo a leer cualquier formato de código
//        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
//        intentIntegrator.setPrompt("Lector de códigos") // Título en cámara
//        intentIntegrator.setCameraId(0) // Definir cámara frontal
//        intentIntegrator.setBeepEnabled(true) // Emitir beep al tomar la foto
//        intentIntegrator.setBarcodeImageEnabled(true) // Almacenar el código
//        intentIntegrator.initiateScan() // Iniciar escaneo
//    }//escanearCodigo
    // Método para determinar qué hacer después de leer el código
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        // Instancia para recibir el resultado (lectura de código)
//        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        // Validar que no esté vacía
//        if (intentResult != null) {
//            // Validar si leyó información
//            if (intentResult.contents == null) {
//                // Mensaje informativo - no hubo datos
//                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show()
//            } else {
//                // Mensaje informativo - sí hubo datos
//                Toast.makeText(this, "Código leído", Toast.LENGTH_SHORT).show()
//                // Colocar el código en la caja de texto
//                codigo.setText(intentResult.contents)
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }//onActivityResult
//
//    private fun limpiar() {
//        codigo.setText("")
//        descripcion.setText("")
//        codigo.requestFocus()
//    }

}//Class Main