package com.example.t6ejercicio1.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6ejercicio1.R
import com.example.t6ejercicio1.adapters.CancionAdapter
import com.example.t6ejercicio1.databinding.FragmentCancionBinding
import com.example.t6ejercicio1.pojo.Album
import com.example.t6ejercicio1.pojo.Cancion
import com.google.android.material.dialog.MaterialAlertDialogBuilder


private var ARG_ALBUM = "album"

class CancionFragment : Fragment(), OnClickCancion {
    private lateinit var binding: FragmentCancionBinding
    private lateinit var cancionAdapter: CancionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var album: Album



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            album = it.getSerializable("mAlbum") as Album
            println("CancionFragment recibió el álbum: ${album.getNombre()}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCancionBinding.inflate(inflater, container, false)
        cancionAdapter = CancionAdapter(album.canciones, this)
        linearLayoutManager = LinearLayoutManager(context)
        binding.rvCancion.apply {
            layoutManager = linearLayoutManager
            adapter = cancionAdapter
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(album: Album) =
            CancionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("mAlbum", album)
                }
            }
    }

    override fun onClickCancion(cancion: Cancion) {
        Log.i("frag", "Has clicado en una canción")
        val dialogView = layoutInflater.inflate(R.layout.dialog_personal, null)
        val titulo = "Título: ${cancion.getNombre()}"
        val duracion = "Duración: ${cancion.getDuracion()}"
        val numero = "Numero: ${cancion.getNumero()}"




        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Información")
            .setView(dialogView)
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.cancel()
            }
            .setCancelable(false)//No podrá desaparecer el diálogo por ningún motivo
            .show()
    }



}
