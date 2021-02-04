package com.lbj.lbj2021android.ui.study.view.calendar

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.provider.ContactsContract
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lbj.lbj2021android.R
import kotlinx.android.synthetic.main.adapter_ui_study_view_calendar.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * 作者：李炳军
 * 创建日期：2021-02-03  17:58
 * 释义：
 */
@SuppressLint("SimpleDateFormat")
class UIStudyViewCalendarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var btnLastMonth: Button
    private lateinit var btnNextMonth: Button
    private lateinit var tvDataTitle: TextView
    private lateinit var recyclerView: RecyclerView

    private val mCalendar = Calendar.getInstance()
    private val mCurrentMonthList = arrayListOf<Date>()
    private val mTitleFormat by lazy { SimpleDateFormat("yyyy年MM月") }

    init {
        val rootView = LayoutInflater.from(context).inflate(R.layout.ui_study_view_calendar, this)
        initView(rootView)
        initClick()
        initData()
        refreshCalendar()
    }

    private fun initView(rootView: View) {
        btnLastMonth = rootView.findViewById(R.id.btnLastMonth)
        btnNextMonth = rootView.findViewById(R.id.btnNextMonth)
        tvDataTitle = rootView.findViewById(R.id.tvDateTitle)
        recyclerView = rootView.findViewById(R.id.recyclerView)
    }

    private fun initClick() {
        btnLastMonth.setOnClickListener {
            mCalendar.add(Calendar.MONTH, -1)
            refreshCalendar()
        }

        btnNextMonth.setOnClickListener {
            mCalendar.add(Calendar.MONTH, 1)
            refreshCalendar()
        }
    }

    private fun initData() {
        // 设置每个月的第一天
        mCalendar.set(Calendar.DAY_OF_MONTH, 1)
        recyclerView.layoutManager = GridLayoutManager(context, 7)
    }

    @SuppressLint("SimpleDateFormat")
    private fun refreshCalendar() {
        // 设置日历标题
        tvDataTitle.text = mTitleFormat.format(mCalendar.time)

        val monthCalendar = mCalendar.clone() as Calendar
        // 设置月份为当月的1号
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        // 以星期天为第一天,获取当月第1日为星期几
        // 星期天：0 星期一:1 ...
        val firstMonthDay = monthCalendar.get(Calendar.DAY_OF_WEEK) - 1
        // 获取当月的天数
        val currentMonthDay = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        // 计算最大的行数[7 * 5] 或 [7 * 6] ==> 当月的天数（30） + 星期几（5,6）
        // 如果本月天数为30天，那么本月第一日为周六，则为6行
        // 如果本月天数为31天，那么本月第一日为周五或周六，则为6行
        val maxCount = if ((currentMonthDay == 30 && firstMonthDay == 6)
            || (currentMonthDay == 31 && firstMonthDay >= 5)
        ) 7 * 6 else 7 * 5

        // 将当月日期往前移动
        monthCalendar.add(Calendar.DAY_OF_MONTH, -firstMonthDay)

        mCurrentMonthList.clear()
        for (index in 0 until maxCount) {
            mCurrentMonthList.add(monthCalendar.time)
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        val adapter = CalendarAdapter(context)
        adapter.setTime(mCurrentMonthList)
        adapter.setCalendar(mCalendar)
        recyclerView.adapter = adapter
    }
}

@SuppressLint("SimpleDateFormat")
class CalendarAdapter(private val context: Context) :
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {

    private val dateList = arrayListOf<Date>()
    private val mDayFormat by lazy { SimpleDateFormat("dd") }
    private var mCurrentCalendar: Calendar? = null

    fun setTime(timeList: ArrayList<Date>) {
        dateList.clear()
        dateList.addAll(timeList)
        notifyDataSetChanged()
    }

    fun setCalendar(monthCalendar: Calendar) {
        mCurrentCalendar = monthCalendar
    }

    class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            val tvTime: UIStudyViewCalendarTextView = itemView.findViewById(R.id.tvTime)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val rootView =
            LayoutInflater.from(context)
                .inflate(R.layout.adapter_ui_study_view_calendar, parent, false)
        return CalendarViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val date = dateList[position]
        holder.itemView.tvTime.text = mDayFormat.format(date)

        mCurrentCalendar?.apply {
            if (date.isThisMonth(time)) {
                holder.itemView.tvTime.setTextColor(Color.parseColor("#000000"))
            } else {
                holder.itemView.tvTime.setTextColor(ContextCompat.getColor(context,R.color.grey_999))
            }
        }

        val now = Date()
        // 今天
        if (date.year == now.year && date.month == now.month && date.date == now.date) {
            holder.itemView.tvTime.setToday(true)
        }
    }

    override fun getItemCount() = dateList.size

    private fun Date.isThisMonth(parentTime: Date): Boolean {
        return isThisTime(this, parentTime, "yyyy-MM")
    }

    private fun isThisTime(childTime: Date, parentTime: Date, format: String): Boolean {
        val sdf = SimpleDateFormat(format)
        val formatOther = sdf.format(childTime)
        val formatNow = sdf.format(parentTime)
        return formatOther == formatNow
    }
}
