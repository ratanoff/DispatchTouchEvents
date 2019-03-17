package ru.ratanov.dispatchtouchevents.view

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.viewpager.widget.ViewPager
import org.jetbrains.anko.toast
import ru.ratanov.dispatchtouchevents.pager.SupportPagerAdapter

class OuterView(context: Context) : FrameLayout(context) {

    private val TAG = this::class.java.simpleName

    private val pager = ViewPager(context).apply { adapter = SupportPagerAdapter(context) }

    private val innerView = InnerView(context)

    init {
        layoutParams =
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)

        addView(innerView)
        addView(pager)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(TAG, "onTouchEvent")
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return if (onInterceptTouchEvent(ev)) pager.onTouchEvent(ev) else innerView.onTouchEvent(ev)
    }


    private var dx = 0f
    private var dy = 0f
    private var isMoving = false
    private var intercept = true

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when(ev.action) {
            MotionEvent.ACTION_DOWN -> {
                isMoving = false
                dx = ev.x
                dy = ev.y
            }
            MotionEvent.ACTION_MOVE -> isMoving = true
            MotionEvent.ACTION_UP -> {
                return !(!isMoving || Math.abs(ev.x - dx) < 10 && Math.abs(ev.y - dy) < 10)
            }

        }

        return intercept
    }


}