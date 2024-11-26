package com.example.t6ejercicio1.fragments

import com.example.t6ejercicio1.pojo.Album

interface AlbumListener {
    fun onAlbumSeleccionado(album: Album)
}