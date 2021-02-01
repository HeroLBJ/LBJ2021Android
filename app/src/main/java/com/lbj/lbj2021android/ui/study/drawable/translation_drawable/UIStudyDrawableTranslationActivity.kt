package com.lbj.lbj2021android.ui.study.drawable.translation_drawable

import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_drawable_translation.*

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  14:49
 * 释义：<translation> 标签使用
 */
class UIStudyDrawableTranslationActivity : AppCompatActivity() {

    private var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_drawable_translation)

        val translationDraw = ivImage.background as TransitionDrawable

        ivImage.setOnClickListener {
            isOpen = !isOpen
            if (isOpen)
                translationDraw.startTransition(200)
            else
                translationDraw.reverseTransition(200)
        }
    }
}