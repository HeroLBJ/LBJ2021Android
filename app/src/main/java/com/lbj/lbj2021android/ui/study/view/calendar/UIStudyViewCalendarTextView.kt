package com.lbj.lbj2021android.ui.study.view.calendar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.lbj.lbj2021android.R

/**
 * 作者：李炳军
 * 创建日期：2021-02-04  15:54
 * 释义：自定义选中文本
 */
class UIStudyViewCalendarTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val paint by lazy {
        Paint().apply {
            isAntiAlias = true
            color = ContextCompat.getColor(context, R.color.blue_666)
        }
    }

    private var isToday = false
    fun setToday(isToday: Boolean) {
        this.isToday = isToday
        setTextColor(Color.WHITE)
    }

    override fun onDraw(canvas: Canvas?) {
        if (isToday)
            canvas?.apply {
                canvas.save()
                translate(width / 2f, height / 2f)
                drawCircle(0f, 0f, width / 2f, paint)
                canvas.restore()
            }
        super.onDraw(canvas)
    }
}