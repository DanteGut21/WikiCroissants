package com.example.wikicroissants
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class Capitulos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_capitulos, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = mutableListOf<String>().apply {
            for (i in 1..7) {
                add("Capítulo $i")
            }
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCapitulo)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AdaptadorCapitulos(myDataset) {item ->

            val intent = Intent(context, Pagina::class.java).apply {
                // Opcional: Pasa información adicional a PaginaActivity
                putExtra("EXTRA_CAPITULO", item)
            }
            startActivity(intent)

            Toast.makeText(context, "Ingresando al $item", Toast.LENGTH_SHORT).show()
        }
    }
}//Class capitulos