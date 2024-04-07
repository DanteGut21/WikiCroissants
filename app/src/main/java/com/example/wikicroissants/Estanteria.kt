package com.example.wikicroissants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikicroissants.models.RespuestaEstante
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

class Estanteria : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_estanteria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.rvEstante).apply {
            layoutManager = LinearLayoutManager(context)
        }
        fetchShelves()
    }

    private fun fetchShelves() {
        Thread {
            try {
                val token = "Token bRT0syWV9NNoNdRJmDXJE4dlAUjfNaJs:FyVfwiHGohEfNUNIgw8QFp3T0LoIepb2"
                val client = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()

                val request = Request.Builder()
                    .url("https://wiki.croissantsalfredo.com/api/shelves")
                    .addHeader("Authorization", token)
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responseBody = response.body?.string() ?: throw IOException("No response body")
                    val gson = Gson()
                    val responseType = object : TypeToken<RespuestaEstante>() {}.type
                    val respuesta: RespuestaEstante = gson.fromJson(responseBody, responseType)

                    activity?.runOnUiThread {
                        recyclerView.adapter = AdaptadorEstantes(respuesta.data) { estante ->
                            Toast.makeText(context, "Ingresando a ${estante.name}", Toast.LENGTH_SHORT).show()
                            val idEstante = "${estante.id}";
                            val nombreEstante = "${estante.name}";
                            val fragmentoLibros = Libros()

                            // Crea un Bundle para pasar el idEstante
                            val args = Bundle()
                            args.putString("idEstante", idEstante) // Usa "idEstante" como clave para recuperar el valor en el fragmento Libros
                            args.putString("nombreEstante", nombreEstante) // Usa "nombreEstante" como clave para recuperar el valor en el fragmento Libros
                            fragmentoLibros.arguments = args // Establece los argumentos en el fragmento

                            // Aquí se inicia la transacción del fragmento
                            requireActivity().supportFragmentManager.beginTransaction().apply {
                                replace(R.id.fragmentContainer, fragmentoLibros) // Asegúrate de que 'fragmentContainer' es el ID del contenedor de tu fragmento en tu layout
                                addToBackStack(null) // Permite volver al fragmento anterior en la pila
                                commit()
                            }

                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                activity?.runOnUiThread {
                    Toast.makeText(context, "Error fetching data: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }//fetchShelves
}//Class Estanteria