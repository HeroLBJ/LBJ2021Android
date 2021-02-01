package com.lbj.lbj2021android.ui.study.anim.anim_sxdh

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_anim_sxdh01.*

class UIStudyAnimSxdh01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_anim_sxdh01)
    }

    fun onPlay(view:View){
        val anim: ValueAnimator =
            ObjectAnimator.ofInt(ivAnim01, "backgroundColor", 0xffff0000.toInt(), 0xffffff00.toInt())
        anim.duration = 3000
        // 颜色差值器
        anim.setEvaluator(ArgbEvaluator())
        // 动画重复次数 【ValueAnimator.INFINITE：无限循环】
        anim.repeatCount = 2
        // 动画重复模式 【RESTART：重新开始】【RESTART：反转】
        anim.repeatMode = ValueAnimator.REVERSE
        anim.start()
    }
}