package com.ex.logomaker.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ex.logomaker.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    val icons = listOf(
            Images(Image = R.drawable.ic_menu_camera,Name = "Fotoparatas"),
            Images(Image = R.drawable.ic_menu_gallery,Name = "Galerija"),
            Images(Image = R.drawable.ic_menu_send,Name = "Siusti"),
            Images(Image = R.drawable.ic_menu_manage,Name = "Irankis")
    )







    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        val rec = root.findViewById<RecyclerView>(R.id.galerija)

        rec.adapter=Adapter(icons)

        return root
    }
}