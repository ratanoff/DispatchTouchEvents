package ru.ratanov.dispatchtouchevents.pager

import android.content.Context
import android.graphics.Color
import android.view.View
import java.util.*

class FakePageView(context: Context) : View(context) {

    init {
        val rnd = Random()
        val bgColor = Color.argb(40, rnd.nextInt(256),  rnd.nextInt(256),  rnd.nextInt(256))
        setBackgroundColor(bgColor)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasuredSpec = MeasureSpec.makeMeasureSpec(720, MeasureSpec.EXACTLY)
        val heightMeasuredSpec = MeasureSpec.makeMeasureSpec(1280, MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasuredSpec, heightMeasuredSpec)
    }
}