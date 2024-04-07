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
        savedState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_libros, container, false)
    }//onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvLibros)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Recupera el idEstante y el nombre (título) del estante de los argumentos, si es necesario
        val idEstante = arguments?.getString("idEstante", "Libros no disponibles") ?: "Libros no disponibles"
        val tituloEstante = arguments?.getString("nombreEstante", "Título no disponible") ?: "Título no disponible"

        // Encuentra el TextView por su ID y establece el título
        val tvTituloEstante: TextView = view.findViewById(R.id.tvTituloEstante)
        tvTituloEstante.text = tituloEstante

        if (idEstante != "Libros no disponibles") {
            fetchBooks(idEstante)
        } else {
            // Manejar el caso en que idEstante no esté disponible
            Toast.makeText(context, "ID de estante no encontrado", Toast.LENGTH_SHORT).show()
        }
    }//onViewCreated

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
                    // Asegúrate de reemplazar esto con el token de autenticación real si es necesario
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
                            // Reemplaza Toast con la navegación al fragmento de capitulos
                            val fragmentoCapitulos = Capitulos()
                            // Aquí se inicia la transacción del fragmento
                            requireActivity().supportFragmentManager.beginTransaction().apply {
                                replace(R.id.fragmentContainer, fragmentoCapitulos) // Asegúrate de que 'fragmentContainer' es el ID del contenedor de tu fragmento en tu layout
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
    }//fetchBooks
}//Class Libros