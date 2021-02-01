package com.lbj.lbj2021android.util.ui.decoration

import android.content.Context
import android.graphics.drawable.InsetDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.lbj.lbj2021android.R

/**
 * 设置 RecyclerView 的分割线
 */
fun Context.setRecyclerItemDividerLine(): ItemDecoration {
    val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
    ContextCompat.getDrawable(this, R.drawable.inset_recycler_item_line)
        ?.apply {
            val insetDraw = this as InsetDrawable
            itemDecoration.setDrawable(insetDraw)
        }
    return itemDecoration
}