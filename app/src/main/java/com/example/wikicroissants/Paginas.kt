package com.example.wikicroissants
import android.os.Bundle
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