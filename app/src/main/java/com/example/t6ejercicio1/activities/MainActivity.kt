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

        val fragment = supportFragmentManager.findFragmentById(binding.frgContenedor.id) as AlbumFragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frgContenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        fragment.setAlbumListener(this)





    }

    override fun onAlbumSeleccionado(album: Album) {
        val fragment = supportFragmentManager.findFragmentById(binding.frgContenedor.id) as AlbumFragment
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frgContenedor, CancionFragment())
            transaction.addToBackStack(null)
            val mBundle = Bundle()
            mBundle.putSerializable("mAlbum", album)
            fragment.arguments = mBundle



            transaction.commit()


    }
}