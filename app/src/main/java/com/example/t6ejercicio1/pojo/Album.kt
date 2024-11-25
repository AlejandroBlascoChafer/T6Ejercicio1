package com.example.t6ejercicio1.pojo

class Album (private var nombre:String, private var artista:String, private var fechaPublicacion:String){

    fun getNombre():String{
        return nombre
    }
    fun getArtista():String{
        return artista
    }
    fun getFechaPublicacion():String{
        return fechaPublicacion
    }
}

class AlbumDatos{
    companion object{
        val ALBUMES = arrayListOf<Album>(
            Album("LOOM", "Imagine Dragons", "2024"),
            Album("LOOM", "Imagine Dragons", "2024"),
            Album("LOOM", "Imagine Dragons", "2024"),
        )
    }
}