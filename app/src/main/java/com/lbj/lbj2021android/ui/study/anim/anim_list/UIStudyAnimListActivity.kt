package com.lbj.lbj2021android.ui.study.anim.anim_list

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_anim_list.*

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  16:47
 * 释义：帧动画
 */
class UIStudyAnimListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_anim_list)

        val animDraw = ivAnimImage.background as AnimationDrawable
        animDraw.start()
    }
}