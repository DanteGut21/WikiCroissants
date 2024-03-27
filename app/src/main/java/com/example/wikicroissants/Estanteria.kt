package com.example.wikicroissants

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Estanteria : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_estanteria, container, false)
//        val vista = inflater.inflate(R.layout.fragment_estanteria, container, false)

//
//        val linearLayoutClickeable = vista.findViewById<LinearLayout>(R.id.llEstanteIzq)
//        linearLayoutClickeable.setOnClickListener {
//            // Realizar el cambio de fragmento
//            cambiarFragmento(Libros())
//        }
//
//        return vista
    }

//    private fun cambiarFragmento(fragmento: Fragment) {
//        val transaction = parentFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragmentContainer, fragmento)
//        transaction.addToBackStack(null) // Opcional
//        transaction.commit()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = mutableListOf<String>().apply {
            for (i in 1..20) {
                add("Libros $i")
            }
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvEstante)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdaptadorEstantes(myDataset)

    }
}//Class Estanteria