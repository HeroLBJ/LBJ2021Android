package com.lbj.lbj2021android.ui.study.view.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.lbj.lbj2021android.R

/**
 * 作者：李炳军
 * 创建日期：2021-02-03  17:58
 * 释义：
 */
class UIStudyViewCalendarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.ui_study_view_calendar, this)
    }
}