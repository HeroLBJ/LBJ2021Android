package com.lbj.lbj2021android.ui.study.anim.anim_sxdh

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_anim_sxdh02.*

/**
 * 作者：李炳军
 * 创建日期：2021-02-02  09:52
 * 释义：属性动画 - 第2种解决方案
 */
class UIStudyAnimSxdh02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_anim_sxdh02)

        val wrapper = ViewWrapper(btnAnimHello)
        val anim = ObjectAnimator.ofInt(wrapper,"width",100,600)
        anim.duration = 3000
        anim.repeatCount = ValueAnimator.INFINITE
        anim.repeatMode = ValueAnimator.REVERSE
        anim.start()
    }
}

class ViewWrapper(private val target: View) {

    fun getWidth(): Int {
        return target.layoutParams.width
    }

    fun setWidth(width: Int) {
        target.layoutParams.width = width
        target.requestLayout()
    }
}