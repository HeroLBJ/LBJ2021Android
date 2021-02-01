package com.lbj.lbj2021android.ui.study.drawable.clip_drawable

import android.graphics.drawable.ClipDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_drawable_clip.*

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  16:01
 * 释义：<clip> 标签使用
 */
class UIStudyDrawableClipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_drawable_clip)

        val clipDraw = ivClipImage.drawable as ClipDrawable
        // 取值范围 [0,10000] 0表示不裁剪（没有裁剪部分留下来）
        // 10000 表示全部裁剪 所有图片都被保留下来
        // 1000 表示裁剪 10% 的部分
        clipDraw.level = 6000
    }
}