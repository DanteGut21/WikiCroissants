package com.example.wikicroissants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wikicroissants.models.Estante
import com.example.wikicroissants.models.Libros
import com.example.wikicroissants.models.Capitulos

class AdaptadorEstantes(private val dataList: List<Estante>, private val onClick: (Estante) -> Unit) : RecyclerView.Adapter<AdaptadorEstantes.ElementoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_estanteria, parent, false)
        return ElementoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val leftItemIndex = position * 2
        val rightItemIndex = leftItemIndex + 1

        dataList.getOrNull(leftItemIndex)?.let { estante ->
            holder.leftTextView.text = estante.name
            holder.leftDescTextView.text = estante.description // Actualiza la descripción para el lado izquierdo
            holder.leftLinearLayout.setOnClickListener {
                onClick(estante) // Aquí pasamos el objeto Estante correcto
            }
        } ?: run {
            holder.leftLinearLayout.visibility = View.INVISIBLE
        }

        if (rightItemIndex < dataList.size) {
            dataList.getOrNull(rightItemIndex)?.let { estante ->
                holder.rightTextView.text = estante.name
                holder.rightDescTextView.text = estante.description // Actualiza la descripción para el lado derecho
                holder.rightLinearLayout.setOnClickListener {
                    onClick(estante) // Igualmente, asegurarse de pasar el objeto Estante
                }
            }
        } else {
            holder.rightLinearLayout.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = (dataList.size + 1) / 2

    class ElementoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftTextView: TextView = view.findViewById(R.id.tvTituloEstanteIzq)
        val leftDescTextView: TextView = view.findViewById(R.id.tvDescEstanteIzq) // Agrega referencia a la descripción izquierda
        val leftImageView: ImageView = view.findViewById(R.id.imgEstanteIzq)
        val leftLinearLayout: LinearLayout = view.findViewById(R.id.llEstanteIzq)
        val rightTextView: TextView = view.findViewById(R.id.tvTituloEstanteDer)
        val rightDescTextView: TextView = view.findViewById(R.id.tvDesEstanteDer) // Agrega referencia a la descripción derecha
        val rightImageView: ImageView = view.findViewById(R.id.imgEstanteDer)
        val rightLinearLayout: LinearLayout = view.findViewById(R.id.llEstanteDer)
    }
}//Class AdaptadorEstante

class AdaptadorLibros(private val dataLibros: List<Libros>, private val onClick: (Libros) -> Unit) :
    RecyclerView.Adapter<AdaptadorLibros.ElementoViewHolderLibros>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderLibros {
        val adapterLayoutLibros = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_libros, parent, false)
        return ElementoViewHolderLibros(adapterLayoutLibros)
    }

    override fun onBindViewHolder(holder: ElementoViewHolderLibros, position: Int) {
        val leftItemIndex = position * 2
        val rightItemIndex = leftItemIndex + 1

        // Configura el elemento izquierdo
        dataLibros.getOrNull(leftItemIndex)?.let { libro ->
            holder.leftTextView.text = libro.name

            // Suponiendo que 'libro' tiene una imagen, ajusta esto para usar la imagen de 'libro'
            holder.leftImageView.setImageResource(R.drawable.libro)
            holder.leftLinearLayout.setOnClickListener {
                onClick(libro)
            }
        } ?: run {
            // Oculta el LinearLayout izquierdo si no hay elemento
            holder.leftLinearLayout.visibility = View.INVISIBLE
        }

        // Configura el elemento derecho si existe
        dataLibros.getOrNull(rightItemIndex)?.let { libro ->
            holder.rightTextView.text = libro.name

            // Suponiendo que 'libro' tiene una imagen, ajusta esto para usar la imagen de 'libro'
            holder.rightImageView.setImageResource(R.drawable.libro)
            holder.rightLinearLayout.setOnClickListener {
                onClick(libro)
            }
        } ?: run {
            // Oculta el LinearLayout derecho si no hay elemento
            holder.rightLinearLayout.visibility = View.INVISIBLE
        }
    }

    override fun getItemCount(): Int {
        // Redondea hacia arriba para contar el elemento final si la lista tiene un número impar de libros
        return (dataLibros.size + 1) / 2
    }

    class ElementoViewHolderLibros(view: View) : RecyclerView.ViewHolder(view) {
        val leftLinearLayout: LinearLayout = view.findViewById(R.id.llLibroIzq)
        val leftImageView: ImageView = view.findViewById(R.id.imgLibroIzq)
        val leftTextView: TextView = view.findViewById(R.id.tvTituloLibroIzq)
        val leftDescTextView: TextView = view.findViewById(R.id.tvDesLibroIzq)
        val rightLinearLayout: LinearLayout = view.findViewById(R.id.llLibroDer)
        val rightImageView: ImageView = view.findViewById(R.id.imgLibroDer)
        val rightTextView: TextView = view.findViewById(R.id.tvTituloLibroDer)
        val rightDescTextView: TextView = view.findViewById(R.id.tvDesclibroDer)
    }
}

class AdaptadorCapitulos(private val dataCapitulos: List<com.example.wikicroissants.models.Capitulos>, private val onClick: (Capitulos) -> Unit) :
    RecyclerView.Adapter<AdaptadorCapitulos.ElementoViewHolderCapitulos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolderCapitulos {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_capitulos, parent, false)
        return ElementoViewHolderCapitulos(itemView)
    }

    override fun onBindViewHolder(holder: ElementoViewHolderCapitulos, position: Int) {
        val capitulo = dataCapitulos[position]
        holder.textView.text = capitulo.name
        holder.descTextView.text = capitulo.description
        holder.itemView.setOnClickListener {
            onClick(capitulo)
        }
    }

    override fun getItemCount(): Int {
        return dataCapitulos.size
    }

    class ElementoViewHolderCapitulos(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvCapitulo)
        val descTextView: TextView = itemView.findViewById(R.id.tvDescCapitulo)
    }
}