package com.example.wikicroissants
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class Estanteria : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        return inflater.inflate(R.layout.fragment_estanteria, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = mutableListOf<String>().apply {
            for (i in 1..5) {
                add("Departamento $i")
            }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvEstante)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdaptadorEstantes(myDataset) {item ->
            val fragmentoLibros = Libros()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentoLibros)
                .addToBackStack(null)
                .commit()
//            Toast.makeText(context,"Ingresando a $item", Toast.LENGTH_SHORT).show()
        }
    }
}//Class Estanteria