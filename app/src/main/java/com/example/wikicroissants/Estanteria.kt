package com.example.wikicroissants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Estanteria : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_estanteria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = listOf("Libro 1", "Libro 2", "Libro 3")

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvEstante)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdaptadorEstantes(myDataset)

    }
}//Class Estanteria