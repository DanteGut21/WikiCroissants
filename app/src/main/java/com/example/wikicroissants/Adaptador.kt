package com.example.wikicroissants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorEstantes (private val dataList: List<String>, private val onClick: (String) -> Unit):
    RecyclerView.Adapter<AdaptadorEstantes.ElementoViewHolder>(){
    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_estanteria, parent, false)
        return ElementoViewHolder(adapterLayout)
    }
    // Reemplaza el contenido de una vista
    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        // Calcula la posición real en dataList
        val leftItemIndex = position * 2
        val rightItemIndex = leftItemIndex + 1
        // Configura el elemento izquierdo
        val leftItem = dataList[leftItemIndex]
        holder.leftTextView.text = leftItem
        holder.leftImageView.setImageResource(R.drawable.libro)
        holder.leftLinearLayout.setOnClickListener {
            onClick(leftItem)
        }
        // Verifica si hay un elemento derecho para configurar
        if (rightItemIndex < dataList.size) {
            val rightItem = dataList[rightItemIndex]
            holder.rightTextView.text = rightItem
            holder.rightImageView.setImageResource(R.drawable.libro)
            holder.rightLinearLayout.setOnClickListener {
                onClick(rightItem)
            }
        } else {
            // Oculta o desactiva el LinearLayout derecho si no hay elemento
            holder.rightLinearLayout.visibility = View.INVISIBLE
            // O puedes hacerlo inactivo:
            // holder.rightLinearLayout.isEnabled = false

        }
    }
    // Devuelve el tamaño de tu conjunto de datos ajustado para pares
    override fun getItemCount(): Int {
        return (dataList.size + 1) / 2
    }
    class ElementoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftTextView: TextView = view.findViewById(R.id.tvTituloEstanteIzq)
        val leftImageView: ImageView = view.findViewById(R.id.imgEstanteIzq)
        val leftLinearLayout: LinearLayout = view.findViewById(R.id.llEstanteIzq)
        // Asume que tienes identificadores similares para el lado derecho
        val rightTextView: TextView = view.findViewById(R.id.tvTituloEstanteDer)
        val rightImageView: ImageView = view.findViewById(R.id.imgEstanteDer)
        val rightLinearLayout: LinearLayout = view.findViewById(R.id.llEstanteDer)
    }
}//Class AdaptadroEstante
class AdaptadorLibros (private val dataLibros: List<String>, private val onClick: (String) -> Unit):
    RecyclerView.Adapter<AdaptadorLibros.ElementoViewHolderLibros>(){
    // Crea nuevas vistas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderLibros {
        val adapterLayoutLibros = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_libros, parent, false)
        return ElementoViewHolderLibros(adapterLayoutLibros)
    }
    // Reemplaza el contenido de una vista
    override fun onBindViewHolder(holder: ElementoViewHolderLibros, position: Int) {
        // Calcula la posición real en dataList
        val leftItemIndex = position * 2
        val rightItemIndex = leftItemIndex + 1
        // Configura el elemento izquierdo
        val leftItem = dataLibros[leftItemIndex]
        holder.leftTextView.text = leftItem
        holder.leftImageView.setImageResource(R.drawable.libro)
        holder.leftLinearLayout.setOnClickListener {
            onClick(leftItem)
        }
        // Verifica si hay un elemento derecho para configurar
        if (rightItemIndex < dataLibros.size) {
            val rightItem = dataLibros[rightItemIndex]
            holder.rightTextView.text = rightItem
            holder.rightImageView.setImageResource(R.drawable.libro)
            holder.rightLinearLayout.setOnClickListener {
                onClick(rightItem)
            }
        } else {
            // Oculta o desactiva el LinearLayout derecho si no hay elemento
            holder.rightLinearLayout.visibility = View.INVISIBLE
            // O puedes hacerlo inactivo:
            // holder.rightLinearLayout.isEnabled = false
        }
    }
    // Devuelve el tamaño de tu conjunto de datos ajustado para pares
    override fun getItemCount(): Int {
        return (dataLibros.size + 1) / 2
    }
    class ElementoViewHolderLibros(view: View) : RecyclerView.ViewHolder(view) {
        val leftTextView: TextView = view.findViewById(R.id.tvTituloLibroIzq)
        val leftImageView: ImageView = view.findViewById(R.id.imgLibroIzq)
        val leftLinearLayout: LinearLayout = view.findViewById(R.id.llLibroIzq)
        // Asume que tienes identificadores similares para el lado derecho
        val rightTextView: TextView = view.findViewById(R.id.tvTituloLibroDer)
        val rightImageView: ImageView = view.findViewById(R.id.imgLibroDer)
        val rightLinearLayout: LinearLayout = view.findViewById(R.id.llLibroDer)
    }
}//Class AdaptadorLibros

class AdaptadorCapitulos (private val dataCapitulos: List<String>, private val onClick: (String) -> Unit):
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
        holder.itemView.findViewById<LinearLayout>(R.id.llConten1).setOnClickListener {
            onClick(currentItem)
        }
    }
    // Retorna el tamaño de tu dataset (invocado por el layout manager)
    override fun getItemCount() = dataCapitulos.size
    // Proporciona una referencia a las vistas para cada elemento de datos
    class ElementoViewHolderCapitulos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvCaptiulos)
    }
}//Class Capitulos

