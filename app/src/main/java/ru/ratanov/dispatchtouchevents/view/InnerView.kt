package ru.ratanov.dispatchtouchevents.view

import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.widget.Button
import android.widget.LinearLayout
import org.jetbrains.anko.toast

class InnerView(context: Context) : LinearLayout(context) {

    private val TAG = this::class.java.simpleName

    private val button = Button(context).apply {
        text = "Button"
        setOnClickListener { context.toast("Click") }
    }

    init {
        layoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
        addView(button)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d(TAG, "onTouchEvent = ${event.action}")

        if (event.x in button.left..button.right && event.y in button.top..button.bottom) {
            if (event.action == MotionEvent.ACTION_DOWN) {
                button.isPressed = true
                button.performClick()
                return true
            }

            if (event.action == MotionEvent.ACTION_UP) {
                button.isPressed = true
                button.performClick()
                return true
            }

            if (event.action == MotionEvent.ACTION_MOVE) {
                button.isPressed = false
                return true
            }
        }

        return super.onTouchEvent(event)
    }


}