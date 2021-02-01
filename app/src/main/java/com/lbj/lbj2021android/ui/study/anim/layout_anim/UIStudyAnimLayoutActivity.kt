package com.lbj.lbj2021android.ui.study.anim.layout_anim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.activity_u_i_study_anim_layout.*

/**
 * 作者：李炳军
 * 创建日期：2021-01-29  17:26
 * 释义：LayoutAnimation的使用
 */
class UIStudyAnimLayoutActivity : AppCompatActivity() {

    private val itemList = arrayListOf(
        "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝", "对酒当歌，人生几何，譬如朝露，去日苦多",
        "人生若只如初见，何事秋风悲画扇",
        "曾经沧海难为水，除却巫山不是云",
        "玲珑骰子安红豆，入骨相思知不知。",
        "只愿君心似我心，定不负相思意。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝",
        "平生不会相思，才会相思，便害相思",
        "雨打梨花深闭门，忘了青春，误了青春。",
        "山无陵，江水为竭。冬雷震震，夏雨雪。天地合，乃敢与君绝"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_study_anim_layout)
        rvAnimList.layoutManager = LinearLayoutManager(this)
        val adapter = UIStudyAnimLayoutAdapter(this, itemList)
        rvAnimList.adapter = adapter
    }
}