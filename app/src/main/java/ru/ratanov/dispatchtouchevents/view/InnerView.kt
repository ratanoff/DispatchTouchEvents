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

    private val button1 = Button(context).apply {
        val buttonText = "Button 1"
        text = buttonText
        setOnClickListener { context.toast(buttonText) }
    }

    private val button2 = Button(context).apply {
        val buttonText = "Button 2"
        text = buttonText
        setOnClickListener { context.toast(buttonText) }
    }

    private val buttons = arrayOf(button1, button2)

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
        addView(button1)
        addView(button2)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.d(TAG, "onTouchEvent = ${event.action}")

        buttons.forEach { button ->
            if (event.action == MotionEvent.ACTION_UP && event.x in button.left..button.right && event.y in button.top..button.bottom) {
                button.performClick()
                button.isPressed = true
                handler.postDelayed({ button.isPressed = false }, 200)
                return true
            }
        }

        return super.onTouchEvent(event)
    }


}