package com.example.wikicroissants
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast

lateinit var imgbEstante: ImageButton
lateinit var imgbEdicion: ImageButton
lateinit var imgbUsuario: ImageButton
class Inicio : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }//onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgbEstante: ImageButton = view.findViewById(R.id.imgbEstante)
        imgbEstante.setOnClickListener{
//            Toast.makeText(context, "Estanteria", Toast.LENGTH_SHORT).show()
            val fragmentoEstanteria = Estanteria()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentoEstanteria)
                .addToBackStack(null)
                .commit()
        }//setOnClickListener
        val imgbEdicion: ImageButton = view.findViewById(R.id.imgbEdicion)
        imgbEdicion.setOnClickListener{
//            Toast.makeText(context, "CRUD", Toast.LENGTH_SHORT).show()
            val fragmentoCRUD = CRUD()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentoCRUD)
                .addToBackStack(null)
                .commit()
        }//setOnClickListener imgbEdicion
        val imgbUsuario: ImageButton = view.findViewById(R.id.imgbUsuario)
        imgbUsuario.setOnClickListener{
            Toast.makeText(context, "Usuario", Toast.LENGTH_SHORT).show()
        }//setOnClickListenerimgbUsuario
    }//onViewCreated
}//Class Inicio