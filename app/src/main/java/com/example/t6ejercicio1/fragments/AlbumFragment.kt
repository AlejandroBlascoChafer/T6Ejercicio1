package com.example.t6ejercicio1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6ejercicio1.adapters.AlbumAdapter
import com.example.t6ejercicio1.adapters.OnClickListener
import com.example.t6ejercicio1.databinding.FragmentAlbumBinding
import com.example.t6ejercicio1.pojo.Album
import com.example.t6ejercicio1.pojo.Repositorio

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [AlbumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumFragment : Fragment(), OnClickListener {
    private lateinit var binding: FragmentAlbumBinding
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var listener: AlbumListener




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        albumAdapter = AlbumAdapter(Repositorio.RepositorioMusica.albums, this)
        linearLayoutManager = LinearLayoutManager(context)
        binding.rvAlbum.apply{
            layoutManager = linearLayoutManager
            adapter = albumAdapter
        }

        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance(album: Album) =
            AlbumFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("mAlbum", album)
                }
            }
    }

    override fun onClick(album: Album) {
        println("Clic en el álbum dentro del fragmento: ${album.getNombre()}")
        if (::listener.isInitialized){
            listener.onAlbumSeleccionado(album)
        }
    }

    fun setAlbumListener(listener: AlbumListener){
        this.listener=listener
    }


}