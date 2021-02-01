package com.lbj.lbj2021android.ui.study.view.circle_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  10:38
 * 释义：绘制一个圆
 */
class UICircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val minWidth = 100

    // Paint.ANTI_ALIAS_FLAG ： 抗锯齿
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec))
    }

    /**
     * 标准测量模式
     */
    private fun measure(measureSpec: Int): Int {
        val mode = MeasureSpec.getMode(measureSpec)
        val size = MeasureSpec.getSize(measureSpec)
        var result = 0
        result = when (mode) {
            MeasureSpec.EXACTLY -> size
            MeasureSpec.AT_MOST -> {
                minWidth.coerceAtLeast(size)
            }
            else -> minWidth
        }
        return result
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            drawCircle(this)
        }
    }

    /**
     * 绘制一个圆（添加对 padding 的支持）
     */
    private fun drawCircle(canvas: Canvas) {
        // 获取宽的时候要减去左右的padding
        val circleWidth = width - paddingStart - paddingEnd
        // 获取高的时候要减去上下的padding
        val circleHeight = height - paddingTop - paddingBottom
        // 让宽和高最小值的一半为半径，保证圆一定能画完整
        val radius = circleWidth.coerceAtMost(circleHeight) / 2f
        // 绘制圆的时候，坐标点要考虑padding
        canvas.drawCircle(
            circleWidth / 2f + paddingStart,
            circleHeight / 2f + paddingTop,
            radius,
            paint
        )
    }
}