package com.lbj.lbj2021android.ui.study.anim.layout_anim

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lbj.lbj2021android.R

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  17:29
 * 释义：
 */
class UIStudyAnimLayoutAdapter(context: Context, private val itemList: List<String>) :
    RecyclerView.Adapter<UIStudyAnimLayoutAdapter.ViewHolder>() {

    private val inflate: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = inflate.inflate(R.layout.adapter_ui_study_anim_layout, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = itemList[position]
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }
}