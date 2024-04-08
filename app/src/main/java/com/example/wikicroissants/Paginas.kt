package com.example.wikicroissants
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.Html.FROM_HTML_MODE_COMPACT
import android.text.Spanned
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wikicroissants.models.Pagina
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

class Paginas : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paginas, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val capituloId = arguments?.getString("capituloID", "Error") ?: "Error"
        val libroId = arguments?.getString("libroID", "Error") ?: "Error"

        // Ahora que tienes los IDs, puedes utilizarlos para, por ejemplo, cargar los datos específicos de la página.
        if (true /*capituloId != "Error" && libroId != "Error"*/) {
            fetchPages(capituloId, libroId)
        } else {
            Toast.makeText(context, "Paginas no encontradas", Toast.LENGTH_SHORT).show()
        }
    }//onViewCreated
    private fun fetchPages(idCapitulo: String, idLibro: String) {
        Thread {
            try {
                val token = "Token bRT0syWV9NNoNdRJmDXJE4dlAUjfNaJs:FyVfwiHGohEfNUNIgw8QFp3T0LoIepb2"
                val client = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build()

                val request = Request.Builder()
                    .url("https://wiki.croissantsalfredo.com/api/pages/2")
                    .addHeader("Authorization", token)
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")

                    val responseBody = response.body?.string() ?: throw IOException("No response body")
                    val gson = Gson()
                    val responseType = object : TypeToken<Pagina>() {}.type
                    val page: Pagina = gson.fromJson(responseBody, responseType)

                    activity?.runOnUiThread {
                        // Aquí puedes manejar la respuesta de la página como desees

                        val edtPagina: EditText = requireView().findViewById(R.id.edtPagina)
                        val htmlString = "${page.html}"

                        val spanned: Spanned
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                            spanned = Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT)
                        } else {
                            @Suppress("DEPRECATION")
                            spanned = Html.fromHtml(htmlString)
                        }

                        // Convertir Spanned a Editable
                        val editable: Editable = Editable.Factory.getInstance().newEditable(spanned)
                        edtPagina.text = editable

                        edtPagina.isFocusable = false
                        edtPagina.isFocusableInTouchMode = false
                        edtPagina.isClickable = false
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
    fun unlockEditText() {
        val edtPagina: EditText? = view?.findViewById(R.id.edtPagina)
        edtPagina?.let {
            it.isFocusable = true
            it.isFocusableInTouchMode = true
            it.isClickable = true
        }
    }

    fun saveText() {
        val edtPagina: EditText? = view?.findViewById(R.id.edtPagina)
        val texto = edtPagina?.text.toString()
        // Aquí puedes guardar el texto en SharedPreferences, una base de datos, etc.
        // Ejemplo: guardarTexto(texto)

        // Bloquear nuevamente el EditText
        edtPagina?.let {
            it.isFocusable = false
            it.isFocusableInTouchMode = false
            it.isClickable = false
        }
    }
}//Class Paginas