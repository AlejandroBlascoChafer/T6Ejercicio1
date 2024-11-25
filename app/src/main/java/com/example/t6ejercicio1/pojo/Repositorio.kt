package com.example.t6ejercicio1.pojo

class Repositorio {
    object RepositorioMusica {
        val albums = listOf(
            Album(
                nombre = "Night Visions",
                artista = "Imagine Dragons",
                fechaPublicacion = "4 de septiembre de 2012",
                canciones = listOf(
                    Cancion(1, "Radioactive", "3:06"),
                    Cancion(2, "Demons", "2:57"),
                    Cancion(3, "It's Time", "3:59"),
                    Cancion(4, "On Top of the World", "3:12")
                )
            ),
            Album(
                nombre = "Smoke + Mirrors",
                artista = "Imagine Dragons",
                fechaPublicacion = "17 de febrero de 2015",
                canciones = listOf(
                    Cancion(1, "Shots", "3:52"),
                    Cancion(2, "Gold", "3:36"),
                    Cancion(3, "Smoke and Mirrors", "4:20"),
                    Cancion(4, "I Bet My Life", "3:14")
                )
            ),
            Album(
                nombre = "World Domination",
                artista = "Band-Maid",
                fechaPublicacion = "14 de febrero de 2018",
                canciones = listOf(
                    Cancion(1, "Domination", "3:48"),
                    Cancion(2, "Play", "3:15"),
                    Cancion(3, "DICE", "3:18"),
                    Cancion(4, "anemone", "4:22")
                )
            ),
            Album(
                nombre = "Conqueror",
                artista = "Band-Maid",
                fechaPublicacion = "19 de octubre de 2016",
                canciones = listOf(
                    Cancion(1, "Blooming", "3:49"),
                    Cancion(2, "Reincarnation", "3:27"),
                    Cancion(3, "Azure", "2:49"),
                    Cancion(4, "At the drop of a hat", "4:19")
                )
            )
        )
    }


}