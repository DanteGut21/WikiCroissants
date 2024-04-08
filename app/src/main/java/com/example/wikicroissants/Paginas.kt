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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val edtPagina: EditText = view.findViewById(R.id.edtPagina)
        val htmlString = "<h2>Título</h2><br><p>Este es un <b>texto</b> de ejemplo con <i>HTML</i>.</p>"

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
    }//onViewCreated

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