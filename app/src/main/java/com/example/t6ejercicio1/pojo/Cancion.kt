package com.example.t6ejercicio1.pojo

class Cancion(private var numero:String, private var nombre:String, private var duracion:String) {

    fun getNombre():String{
        return nombre
    }
    fun getDuracion():String{
        return duracion
    }
    fun getNumero():String{
        return numero
    }

}