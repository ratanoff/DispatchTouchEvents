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

    private var startX = 0f
    private var startY = 0f
    private val touchSlop = ViewConfiguration.get(context).scaledTouchSlop

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        if (event.action == MotionEvent.ACTION_UP) {
            pager.dispatchTouchEvent(event)
            innerView.dispatchTouchEvent(event)
        }

        if (event.action == MotionEvent.ACTION_DOWN) {
            startX = event.x
            startY = event.y

            pager.dispatchTouchEvent(event)
            innerView.dispatchTouchEvent(event)
        }

        if (event.action == MotionEvent.ACTION_MOVE) {
            if (Math.abs(event.x - startX) < touchSlop && Math.abs(event.y - startY) < touchSlop) {
                innerView.dispatchTouchEvent(event)
            } else {
                pager.dispatchTouchEvent(   event)
            }

        }

        return true
    }

}