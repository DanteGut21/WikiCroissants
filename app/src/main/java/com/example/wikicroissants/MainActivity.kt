package com.example.wikicroissants
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.wikicroissants.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var notificacion: Notificacion
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
        binding.btnScanQR.setOnClickListener{ escanearCodigo()}
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
    }//escanearCodigo
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        intentResult?.contents?.let { contents ->
            Toast.makeText(this, "Código leído: $contents", Toast.LENGTH_SHORT).show()
            if (contents == "070847036715") {
                val newIntent = Intent(this, Principal::class.java)
                startActivity(newIntent)
            }
        } ?: run {
            Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show()
        }
    }//onActivityResult
}//Class Main