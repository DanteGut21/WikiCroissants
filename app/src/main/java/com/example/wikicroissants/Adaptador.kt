package com.example.wikicroissants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickedListener {
    fun onItemClicked(position: Int)
}

class AdaptadorEstantes (private val dataList: List<String>) :
    RecyclerView.Adapter<AdaptadorEstantes.ElementoViewHolder>(){//Class Adaptadror
    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        // Crea una nueva vista usando el layout definido anteriormente
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_estanteria, parent, false)
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
        val textView: TextView = view.findViewById(R.id.tvTituloEstanteIzq)
        val imageView: ImageView = view.findViewById(R.id.imgEstanteIzq)
    }

}//Class AdaptadroEstante

class AdaptadorLibros (private val dataLibros: List<String>) :
RecyclerView.Adapter<AdaptadorLibros.ElementoViewHolderLibros>(){

    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderLibros {
        // Crea una nueva vista usando el layout definido anteriormente
        val adapterLayoutLibros = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_libros, parent, false)
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
//        val textView: TextView = view.findViewById(R.id.tvDesLibrosL)
//        val imageView: ImageView = view.findViewById(R.id.imgLibroL)

        val textView: TextView = view.findViewById(R.id.tvTituloLibroIzq)
        val imageView: ImageView = view.findViewById(R.id.imgLibroIzq)
    }


}//Class AdaptadorLibros

class AdaptadorCapitulos (private val dataCapitulos: List<String>) :
    RecyclerView.Adapter<AdaptadorCapitulos.ElementoViewHolderCapitulos>(){

    // Crea nuevas vistas (invocadas por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderCapitulos {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_capitulos, parent, false)
        return ElementoViewHolderCapitulos(itemView)
    }

    // Reemplaza el contenido de una vista (invocada por el layout manager)
    override fun onBindViewHolder(holder: ElementoViewHolderCapitulos, position: Int) {
        val currentItem = dataCapitulos[position]
        holder.textView.text = currentItem
    }

    // Retorna el tamaño de tu dataset (invocado por el layout manager)
    override fun getItemCount() = dataCapitulos.size
    // Proporciona una referencia a las vistas para cada elemento de datos
    class ElementoViewHolderCapitulos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvCaptiulos)
    }
}//Class Capitulos

// class AdaptadorPaginas (private val dataPaginas: List<String>) :
//    RecyclerView.Adapter<AdaptadorPaginas.ElementoViewHolderPaginas>(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderPaginas {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_capitulos, parent, false)
//        return ElementoViewHolderPaginas(itemView)
//    }
//    override fun onBindViewHolder(holder: ElementoViewHolderPaginas, position: Int) {
//        val currentItem = dataPaginas[position]
//        holder.textView.text = currentItem
//    }
//    override fun getItemCount() = dataPaginas.size
//    class ElementoViewHolderPaginas(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val textView: TextView = itemView.findViewById(R.id.tvPagina)
//    }
//}//Class Capitulos
//
