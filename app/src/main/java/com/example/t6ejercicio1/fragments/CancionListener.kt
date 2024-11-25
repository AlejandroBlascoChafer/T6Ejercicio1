package com.example.t6ejercicio1.fragments

import com.example.t6ejercicio1.pojo.Album

interface CancionListener {
    fun onCancionSeleccionada(album: Album)
}