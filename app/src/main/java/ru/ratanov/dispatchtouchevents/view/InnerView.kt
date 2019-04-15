package ru.ratanov.dispatchtouchevents.view

import android.content.Context
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
        setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                context.toast("touched button 2")
            }
            true
        }
    }

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
        addView(button1)
        addView(button2)
    }

}