package com.example.t6ejercicio1.pojo

class Album (private var nombre:String, private var artista:String, private var fechaPublicacion:String, val canciones: List<Cancion>){

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