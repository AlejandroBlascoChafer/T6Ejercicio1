package com.example.t6ejercicio1.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t6ejercicio1.R
import com.example.t6ejercicio1.databinding.ActivityMainBinding
import com.example.t6ejercicio1.fragments.AlbumFragment
import com.example.t6ejercicio1.fragments.AlbumListener
import com.example.t6ejercicio1.fragments.CancionFragment
import com.example.t6ejercicio1.pojo.Album

class MainActivity : AppCompatActivity(), AlbumListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        if (savedInstanceState == null) {
            // Cargar el AlbumFragment como fragmento inicial
            val albumFragment = AlbumFragment()
            supportFragmentManager.beginTransaction()
                .replace(binding.frgContenedor.id, albumFragment)
                .commit()
        } else {
            val fragment = supportFragmentManager.findFragmentById(binding.frgContenedor.id)

            if (fragment is AlbumFragment){
                fragment.setAlbumListener(this)
            }
        }







    }

    override fun onAlbumSeleccionado(album: Album) {
        println("Inicio de onAlbumSeleccionado para el álbum: ${album.getNombre()}")

        // Crear el fragmento de canciones
        val cancionFragment = CancionFragment.newInstance(album)
        val mBundle = Bundle()
        mBundle.putSerializable("mAlbum", album)
        cancionFragment.arguments = mBundle

        println("Bundle creado con el álbum: ${album.getNombre()}")

        // Intentar reemplazar el fragmento
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frgContenedor, cancionFragment)
        transaction.addToBackStack(null)
        transaction.commit()

        println("Transacción de fragmentos realizada")


    }
}