package com.example.t6ejercicio1.activities

import android.os.Bundle
import android.view.View
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


        val fragment = AlbumFragment()
        fragment.setAlbumListener(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frgContenedor, fragment)
            .commit()







    }

    override fun onAlbumSeleccionado(album: Album) {

        val hayCancion = findViewById<View?>(R.id.frgContenedorCancion) != null

        if (hayCancion){
            val cancionFragment = CancionFragment.newInstance(album)


            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frgContenedorCancion, cancionFragment)
            transaction.addToBackStack(null)
            transaction.commit()

        } else {
            val cancionFragment = CancionFragment.newInstance(album)


            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frgContenedor, cancionFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}