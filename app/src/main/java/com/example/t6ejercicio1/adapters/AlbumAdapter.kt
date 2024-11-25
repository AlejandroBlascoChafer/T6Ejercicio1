package com.example.t6ejercicio1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t6ejercicio1.R
import com.example.t6ejercicio1.databinding.ListItemAlbumBinding
import com.example.t6ejercicio1.pojo.Album

class AlbumAdapter(private var albumes: List<Album>):
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

        private lateinit var context:Context

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemAlbumBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_album, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = albumes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumes.get(position)
        with(holder){
            binding.tvNombreAlbum.text = album.getNombre()
            val artistaFecha = album.getArtista() + " - " + album.getFechaPublicacion()
            binding.tvArtistaFecha.text = artistaFecha
        }
    }
}