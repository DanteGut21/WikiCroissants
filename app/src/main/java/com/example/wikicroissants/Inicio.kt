package com.example.wikicroissants
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

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
        val BTNEstante: Button = view.findViewById(R.id.imgbEstante)
        BTNEstante.setOnClickListener{
//            Toast.makeText(context, "Estanteria", Toast.LENGTH_SHORT).show()
            val fragmentoEstanteria = Estanteria()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentoEstanteria)
                .addToBackStack(null)
                .commit()
        }//setOnClickListener
        val btnUsuario: Button = view.findViewById(R.id.imgbUsuario)
        btnUsuario.setOnClickListener{
            Toast.makeText(context, "Usuario", Toast.LENGTH_SHORT).show()
        }//setOnClickListenerimgbUsuario
    }//onViewCreated
}//Class Inicio