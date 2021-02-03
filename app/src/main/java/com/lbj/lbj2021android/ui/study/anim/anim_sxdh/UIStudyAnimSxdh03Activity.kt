package com.lbj.lbj2021android.ui.study.anim.anim_sxdh

import android.animation.IntEvaluator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_anim_sxdh03.*

/**
 * 作者：李炳军
 * 创建日期：2021-02-02  09:52
 * 释义：属性动画 - 第三种解决方案
 */
class UIStudyAnimSxdh03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_anim_sxdh03)

        btnAnim.setOnClickListener {
            val intEvaluator = IntEvaluator()
            val startValue = btnAnim.width
            val anim = ValueAnimator.ofInt(1, 100)
            anim.addUpdateListener {
                // it.animatedValue：[0 ~ 100]
                // it.animatedFraction：[0 ~ 1]
                btnAnim.layoutParams.width = intEvaluator.evaluate(it.animatedFraction, startValue, 600)
                btnAnim.requestLayout()
            }
            anim.duration = 3000
            anim.start()
        }
    }
}