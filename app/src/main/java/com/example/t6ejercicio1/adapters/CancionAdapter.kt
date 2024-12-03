package com.example.t6ejercicio1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t6ejercicio1.R
import com.example.t6ejercicio1.databinding.ListItemCancionBinding
import com.example.t6ejercicio1.fragments.OnClickCancion
import com.example.t6ejercicio1.pojo.Album
import com.example.t6ejercicio1.pojo.Cancion

class CancionAdapter(private val canciones: List<Cancion>, private val listener: OnClickCancion) : RecyclerView.Adapter<CancionAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemCancionBinding.bind(view)
        fun setListener(cancion: Cancion){
            binding.root.setOnClickListener {
               listener.onClickCancion(cancion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_cancion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cancion = canciones[position]
        with(holder){
            setListener(cancion)
            val nombre:String = cancion.getNumero() + ". " + cancion.getNombre()
            binding.tvNombreCancion.text = nombre
            binding.tvDuracion.text = cancion.getDuracion()
        }
    }

    override fun getItemCount(): Int = canciones.size
}
