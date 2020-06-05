package com.claire.trymergeadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claire.trymergeadapter.ClickListener
import com.claire.trymergeadapter.R
import com.claire.trymergeadapter.holder.BufferoosViewHolder
import com.claire.trymergeadapter.model.Bufferoo

class BufferoosAdapter(private val listener: ClickListener) :
    RecyclerView.Adapter<BufferoosViewHolder>() {

    var bufferoos: List<Bufferoo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BufferoosViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_bufferoo, parent, false)
        return BufferoosViewHolder(view, listener)
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_bufferoo


    override fun getItemCount(): Int = bufferoos.size

    override fun onBindViewHolder(holder: BufferoosViewHolder, position: Int) {
        holder.bind(bufferoos[position])
    }
}