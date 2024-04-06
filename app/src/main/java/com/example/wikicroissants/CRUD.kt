package com.example.wikicroissants
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class CRUD : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_r_u_d, container, false)
    }//onCreateView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener el LinearLayout de cada acción
        val llAgregar = view.findViewById<LinearLayout>(R.id.llCRUDAgregar)
        val llModificar = view.findViewById<LinearLayout>(R.id.llCRUDModificar)
        val llEliminar = view.findViewById<LinearLayout>(R.id.llCRUDEliminar)

        // Inicialmente ocultar todos
        llAgregar.visibility = View.GONE
        llModificar.visibility = View.GONE
        llEliminar.visibility = View.GONE

        // Revisar los argumentos y mostrar la vista correspondiente
        when (arguments?.getString("ACTION")) {
            "ADD" -> llAgregar.visibility = View.VISIBLE
            "MODIFY" -> llModificar.visibility = View.VISIBLE
            "DELETE" -> llEliminar.visibility = View.VISIBLE
        }
    }



}//Class CRUD