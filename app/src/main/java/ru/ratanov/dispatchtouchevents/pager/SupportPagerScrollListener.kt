package ru.ratanov.dispatchtouchevents.pager

import androidx.viewpager.widget.ViewPager


class SupportPagerScrollListener(private val callback: (scroll: Float) -> Unit) : ViewPager.SimpleOnPageChangeListener() {

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        val page = 1 / 4f * position
        val movePosition = page + positionOffset / 4

        callback.invoke(movePosition)
    }

}