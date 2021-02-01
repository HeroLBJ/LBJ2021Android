package com.lbj.lbj2021android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lbj.lbj2021android.main.MainAdapter
import com.lbj.lbj2021android.util.ui.decoration.setRecyclerItemDividerLine
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf(
            "爱在西元前", "外婆的澎湖湾", "亲爱的还幸福么", "我在那一角落患过伤风", "你的酒馆对我打了烊"
        )

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.addItemDecoration(setRecyclerItemDividerLine())
        rvList.adapter = MainAdapter(this, list)
    }
}