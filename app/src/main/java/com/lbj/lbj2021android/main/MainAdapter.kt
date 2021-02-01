package com.lbj.lbj2021android.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lbj.lbj2021android.R

class MainAdapter(private val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val rootView: View = itemView.findViewById(R.id.rootView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val rootView = inflater.inflate(R.layout.adapter_main, parent, false)
        return MainHolder(rootView)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val result = list[position]
        holder.tvTitle.text = result
        holder.rootView.setOnClickListener {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = list.size
}