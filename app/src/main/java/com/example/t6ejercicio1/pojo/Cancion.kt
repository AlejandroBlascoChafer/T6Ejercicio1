package com.example.t6ejercicio1.pojo

class Cancion(private var nombre:String, private var duracion:String, private var numero:Int) {

    fun getNombre():String{
        return nombre
    }
    fun getDuracion():String{
        return duracion
    }
    fun getNumero():Int{
        return numero
    }

}