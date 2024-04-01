package com.example.wikicroissants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Libros : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_libros, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = mutableListOf<String>().apply {
            for (i in 1..5) {
                add("Libro $i")
            }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvLibros)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdaptadorLibros(myDataset){item ->
            val fragmentoCapitulos = Capitulos()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentoCapitulos)
                .addToBackStack(null)
                .commit()
//            Toast.makeText(context,"Ingresando a $item", Toast.LENGTH_SHORT).show()
        }
    }
}//Class Libros