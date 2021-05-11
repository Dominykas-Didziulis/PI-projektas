package com.ex.logomaker.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ex.logomaker.R

class Adapter (val duom: List<Images>) : RecyclerView.Adapter<Adapter.ViewHolder>()
{
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val pav = view.findViewById<ImageView>(R.id.Gal2)
        val nam = view.findViewById<TextView>(R.id.Gal1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return duom.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dat = duom[position]
        holder.pav.setImageResource(dat.Image)
        holder.nam.text = dat.Name

    }
}