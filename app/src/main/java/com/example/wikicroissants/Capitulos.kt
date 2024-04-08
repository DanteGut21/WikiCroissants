package com.example.wikicroissants
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikicroissants.models.RespuestaCapitulo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

class Capitulos : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_capitulos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.rvCapitulo).apply {
            layoutManager = LinearLayoutManager(context)
        }
        fetchChapters()
    }

    private fun fetchChapters() {
        Thread {
            try {
                val token = "Token bRT0syWV9NNoNdRJmDXJE4dlAUjfNaJs:FyVfwiHGohEfNUNIgw8QFp3T0LoIepb2"
                val client = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()

                val request = Request.Builder()
                    .url("https://wiki.croissantsalfredo.com/api/chapters")
                    .addHeader("Authorization", token)
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responseBody = response.body?.string() ?: throw IOException("No response body")
                    val gson = Gson()
                    val responseType = object : TypeToken<RespuestaCapitulo>() {}.type
                    val respuestaCapitulo: RespuestaCapitulo = gson.fromJson(responseBody, responseType)

                    requireActivity().runOnUiThread {
                        recyclerView.adapter = AdaptadorCapitulos(respuestaCapitulo.data) { Capitulo ->
//                            // Reemplaza Toast con la navegación al fragmento de capitulos
//                            val fragmentoPaginas = Paginas()
//                            // Aquí se inicia la transacción del fragmento
//                            requireActivity().supportFragmentManager.beginTransaction().apply {
//                                replace(R.id.fragmentContainer, fragmentoPaginas) // Asegúrate de que 'fragmentContainer' es el ID del contenedor de tu fragmento en tu layout
//                                addToBackStack(null) // Permite volver al fragmento anterior en la pila
//                                commit()
//                            }
                            val intent = Intent(context, Pagina::class.java).apply {
                                // Opcional: Pasa información adicional a PaginaActivity
                                                            }
                            startActivity(intent)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                requireActivity().runOnUiThread {
                    Toast.makeText(context, "Error fetching data: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }.start()
    }
}