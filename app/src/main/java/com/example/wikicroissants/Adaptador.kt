package com.example.wikicroissants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorEstantes (private val dataList: List<String>) :
    RecyclerView.Adapter<AdaptadorEstantes.ElementoViewHolder>(){//Class Adaptadror
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
    class ElementoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvDescrip)
        val imageView: ImageView = view.findViewById(R.id.imgIcono)
    }
}//Class AdaptadroEstante

class AdaptadorLibros (private val dataLibros: List<String>) :
RecyclerView.Adapter<AdaptadorLibros.ElementoViewHolderLibros>(){

    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderLibros {
        // Crea una nueva vista usando el layout definido anteriormente
        val adapterLayoutLibros = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ElementoViewHolderLibros(adapterLayoutLibros)
    }
    // Reemplaza el contenido de una vista
    override fun onBindViewHolder(holder: ElementoViewHolderLibros, position: Int) {
        val item = dataLibros[position]
        holder.textView.text = item
        // Establece la misma imagen predefinida para todos los elementos
        holder.imageView.setImageResource(R.drawable.libro)
    }
    // Devuelve el tamaño de tu conjunto de datos
    override fun getItemCount() = dataLibros.size

    class ElementoViewHolderLibros(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.tvDescrip)
        val imageView: ImageView = view.findViewById(R.id.imgIcono)
    }


}//Class AdaptadorLibros

//class AdaptadorPaginas (private val dataList: List<String>) :
//    RecyclerView.Adapter<Adaptador.ElementoViewHolderPaginas>(){
//
//    // Proporciona una referencia a las vistas para cada elemento de datos
//    class ElementoViewHolderLibros(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textView: TextView = itemView.findViewById(R.id.tvLibros)
//    }
//
//    // Crea nuevas vistas (invocadas por el layout manager)
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderLibros {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
//        return ElementoViewHolderLibros(itemView)
//    }
//
//    // Reemplaza el contenido de una vista (invocada por el layout manager)
//    override fun onBindViewHolder(holder: ElementoViewHolderLibros, position: Int) {
//        val currentItem = dataList[position]
//        holder.textView.text = currentItem
//    }
//
//    // Retorna el tamaño de tu dataset (invocado por el layout manager)
//    override fun getItemCount() = dataList.size
//
//    // Define una clase para el ViewHolder
//
//}//Class Paginas