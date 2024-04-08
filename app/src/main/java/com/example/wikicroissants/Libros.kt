package com.example.wikicroissants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikicroissants.models.RespuestaLibro
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

class Libros : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_libros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvLibros)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val idEstante = arguments?.getString("idEstante", "Libros no disponibles") ?: "Libros no disponibles"
        val tituloEstante = arguments?.getString("nombreEstante", "Título no disponible") ?: "Título no disponible"

        val tvTituloEstante: TextView = view.findViewById(R.id.tvTituloEstante)
        tvTituloEstante.text = tituloEstante

        if (idEstante != "Libros no disponibles") {
            fetchBooks(idEstante)
        } else {
            Toast.makeText(context, "ID de estante no encontrado", Toast.LENGTH_SHORT).show()
        }

    }

    private fun fetchBooks(idEstante: String) {
        Thread {
            try {
                val client = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()

                val request = Request.Builder()
                    .url("https://wiki.croissantsalfredo.com/api/shelves/$idEstante")
                    .addHeader("Authorization", "Token bRT0syWV9NNoNdRJmDXJE4dlAUjfNaJs:FyVfwiHGohEfNUNIgw8QFp3T0LoIepb2")
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responseBody = response.body?.string() ?: throw IOException("No response body")
                    val gson = Gson()
                    val responseType = object : TypeToken<RespuestaLibro>() {}.type
                    val respuestaLibro: RespuestaLibro = gson.fromJson(responseBody, responseType)

                    requireActivity().runOnUiThread {
                        recyclerView.adapter = AdaptadorLibros(respuestaLibro.books) { libro ->
                            Toast.makeText(context, "Ingresando a ${libro.name}", Toast.LENGTH_SHORT).show()
                            val idLibro = "${libro.id}";
                            val nombreLibro = "${libro.name}";
                            // Aquí se maneja el click en un libro, pasando el idLibro a Capitulos
                            val fragmentoCapitulos = Capitulos()
                            val args = Bundle()
                            args.putString("idLibro", idLibro) // Usa "idLibro" como clave para recuperar el valor en el fragmento Libros
                            args.putString("nombreLibro", nombreLibro) // Usa "nombreLibro" como clave para recuperar el valor en el fragmento Libros
                            fragmentoCapitulos.arguments = args // Establece los argumentos en el fragmento



                            // Inicia la transacción del fragmento
                            requireActivity().supportFragmentManager.beginTransaction().apply {
                                replace(R.id.fragmentContainer, fragmentoCapitulos)
                                addToBackStack(null)
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
    }
}