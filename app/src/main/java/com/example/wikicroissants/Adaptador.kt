package com.example.wikicroissants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador (private val dataList: List<String>) :
    RecyclerView.Adapter<Adaptador.ElementoViewHolder>(){
//
//    // Proporciona una referencia a las vistas para cada elemento de datos
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textView: TextView = itemView.findViewById(R.id.tvEstante)
//    }
//
//    // Crea nuevas vistas (invocadas por el layout manager)
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    // Reemplaza el contenido de una vista (invocada por el layout manager)
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = dataList[position]
//        holder.textView.text = currentItem
//    }
//
//    // Retorna el tamaño de tu dataset (invocado por el layout manager)
//    override fun getItemCount() = dataList.size

    // Define una clase para el ViewHolder
    class ElementoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvEstante)
        val imageView: ImageView = view.findViewById(R.id.imgEstante)
    }

    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        // Crea una nueva vista usando el layout definido anteriormente
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ElementoViewHolder(adapterLayout)
    }

    // Reemplaza el contenido de una vista
    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val item = dataList[position]
        holder.textView.text = item
        // Establece la misma imagen predefinida para todos los elementos
        holder.imageView.setImageResource(R.drawable.libro)
    }

    // Devuelve el tamaño de tu conjunto de datos
    override fun getItemCount() = dataList.size

}//Class Adaptadror