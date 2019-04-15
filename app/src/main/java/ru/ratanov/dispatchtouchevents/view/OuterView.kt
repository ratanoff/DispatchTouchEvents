package ru.ratanov.dispatchtouchevents.view

import android.content.Context
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import ru.ratanov.dispatchtouchevents.pager.SupportPagerAdapter

class OuterView(context: Context) : FrameLayout(context) {

    private val TAG = this::class.java.simpleName

    private val pager = ViewPager(context).apply { adapter = SupportPagerAdapter(context) }

    private val innerView = InnerView(context)

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        addView(innerView)
        addView(pager)
    }


    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        pager.dispatchTouchEvent(event)
        innerView.dispatchTouchEvent(event)

        return true
    }

}