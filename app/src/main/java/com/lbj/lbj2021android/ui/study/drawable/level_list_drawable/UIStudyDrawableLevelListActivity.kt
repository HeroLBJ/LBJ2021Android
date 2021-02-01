package com.lbj.lbj2021android.ui.study.drawable.level_list_drawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_drawable_level_list.*

class UIStudyDrawableLevelListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_drawable_level_list)

        imageView.setImageLevel(300)
    }
}