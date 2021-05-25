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
            Images(Image =R.drawable.tra_1),
            Images(Image =R.drawable.tra_2),
            Images(Image =R.drawable.tra_3),
            Images(Image =R.drawable.tra_4),
            Images(Image =R.drawable.tra_5),
            Images(Image =R.drawable.tra_6),
            Images(Image =R.drawable.tra_7),
            Images(Image =R.drawable.tra_8),
            Images(Image =R.drawable.tra_9),
            Images(Image =R.drawable.tra_10),
            Images(Image =R.drawable.tra_11),
            Images(Image =R.drawable.tra_12),

            Images(Image =R.drawable.w_1),
            Images(Image =R.drawable.w_2),
            Images(Image =R.drawable.w_3),
            Images(Image =R.drawable.w_4),
            Images(Image =R.drawable.w_5),
            Images(Image =R.drawable.w_6),

            Images(Image =R.drawable.tr_1),
            Images(Image =R.drawable.tr_2),
            Images(Image =R.drawable.tr_3),
            Images(Image =R.drawable.tr_4),
            Images(Image =R.drawable.tr_5),
            Images(Image =R.drawable.tr_6),
            Images(Image =R.drawable.tr_7),
            Images(Image =R.drawable.tr_8),

            Images(Image =R.drawable.t_1),
            Images(Image =R.drawable.t_2),
            Images(Image =R.drawable.t_3),
            Images(Image =R.drawable.t_4),
            Images(Image =R.drawable.t_5),
            Images(Image =R.drawable.t_6),
            Images(Image =R.drawable.t_7),
            Images(Image =R.drawable.t_8),
            Images(Image =R.drawable.t_9),
            Images(Image =R.drawable.t_10),
            Images(Image =R.drawable.t_11),
            Images(Image =R.drawable.t_12),
            Images(Image =R.drawable.t_13),
            Images(Image =R.drawable.t_14),
            Images(Image =R.drawable.t_15),
            Images(Image =R.drawable.t_16),
            Images(Image =R.drawable.t_17),
            Images(Image =R.drawable.t_18),

            Images(Image =R.drawable.se_1),
            Images(Image =R.drawable.se_2),
            Images(Image =R.drawable.se_3),
            Images(Image =R.drawable.se_4),
            Images(Image =R.drawable.se_5),
            Images(Image =R.drawable.se_6),
            Images(Image =R.drawable.se_7),
            Images(Image =R.drawable.se_8),
            Images(Image =R.drawable.se_9),
            Images(Image =R.drawable.se_10),
            Images(Image =R.drawable.se_11),
            Images(Image =R.drawable.se_12),
            Images(Image =R.drawable.se_13),
            Images(Image =R.drawable.se_14),
            Images(Image =R.drawable.se_15),

            Images(Image =R.drawable.s_1),
            Images(Image =R.drawable.s_2),
            Images(Image =R.drawable.s_3),
            Images(Image =R.drawable.s_4),
            Images(Image =R.drawable.s_5),
            Images(Image =R.drawable.s_6),
            Images(Image =R.drawable.s_7),
            Images(Image =R.drawable.s_8),
            Images(Image =R.drawable.s_9),
            Images(Image =R.drawable.s_10),

            Images(Image =R.drawable.pe_1),
            Images(Image =R.drawable.pe_2),
            Images(Image =R.drawable.pe_3),
            Images(Image =R.drawable.pe_4),
            Images(Image =R.drawable.pe_5),
            Images(Image =R.drawable.pe_6),
            Images(Image =R.drawable.pe_7),
            Images(Image =R.drawable.pe_8),
            Images(Image =R.drawable.pe_9),
            Images(Image =R.drawable.pe_10),
            Images(Image =R.drawable.pe_11),
            Images(Image =R.drawable.pe_12),
            Images(Image =R.drawable.pe_13),
            Images(Image =R.drawable.pe_14),
            Images(Image =R.drawable.pe_15),

            Images(Image =R.drawable.p_1),
            Images(Image =R.drawable.p_2),
            Images(Image =R.drawable.p_3),
            Images(Image =R.drawable.p_4),
            Images(Image =R.drawable.p_5),
            Images(Image =R.drawable.p_6),
            Images(Image =R.drawable.p_7),
            Images(Image =R.drawable.p_8),
            Images(Image =R.drawable.p_9),

            Images(Image =R.drawable.o_1),
            Images(Image =R.drawable.o_2),
            Images(Image =R.drawable.o_3),
            Images(Image =R.drawable.o_4),
            Images(Image =R.drawable.o_5),
            Images(Image =R.drawable.o_6),
            Images(Image =R.drawable.o_7),
            Images(Image =R.drawable.o_8),
            Images(Image =R.drawable.o_9),
            Images(Image =R.drawable.o_10),
            Images(Image =R.drawable.o_11),
            Images(Image =R.drawable.o_12),

            Images(Image =R.drawable.n_1),
            Images(Image =R.drawable.n_2),
            Images(Image =R.drawable.n_3),
            Images(Image =R.drawable.n_4),
            Images(Image =R.drawable.n_5),
            Images(Image =R.drawable.n_6),
            Images(Image =R.drawable.n_7),
            Images(Image =R.drawable.n_8),
            Images(Image =R.drawable.n_9),
            Images(Image =R.drawable.n_10),
            Images(Image =R.drawable.n_11),
            Images(Image =R.drawable.n_12),
            Images(Image =R.drawable.n_13),
            Images(Image =R.drawable.n_14),
            Images(Image =R.drawable.n_15),
            Images(Image =R.drawable.n_16),
            Images(Image =R.drawable.n_17),

            Images(Image =R.drawable.a_1),
            Images(Image =R.drawable.a_2),
            Images(Image =R.drawable.a_3),
            Images(Image =R.drawable.a_4),
            Images(Image =R.drawable.a_5),
            Images(Image =R.drawable.a_6),
            Images(Image =R.drawable.a_7),
            Images(Image =R.drawable.a_8),
            Images(Image =R.drawable.a_9),
            Images(Image =R.drawable.a_10),
            Images(Image =R.drawable.a_11),
            Images(Image =R.drawable.a_12),
            Images(Image =R.drawable.a_13),
            Images(Image =R.drawable.a_14),
            Images(Image =R.drawable.a_15),
            Images(Image =R.drawable.a_16)
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