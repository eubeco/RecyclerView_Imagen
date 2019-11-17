package com.example.recyclerview_imagen

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImagesAdapter(var items: ArrayList<Imagen>) : RecyclerView.Adapter<ImagesAdapter.TarjViewHolder>() {

    lateinit var onClick: (View) -> Unit
    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen: ImageView

        init {
            imagen = itemView.findViewById(R.id.idimagen)
        }

        fun bindImagen(img: Imagen, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource (img.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_image, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindImagen(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}