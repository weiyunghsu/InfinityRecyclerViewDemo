package com.jastzeonic.infinityrecyclerviewdemo.component

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

// Method 3
class HorizontalScrollBarDecoration : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDrawOver(c, parent, state)

        val barHeight = SizeUtils.dp2px(2f)
        val scrollWidth = SizeUtils.dp2px(20f)
        val indicatorWidth = SizeUtils.dp2px(6f)
        val paddingBottom = SizeUtils.dp2px(9f)
        val barX = (parent.width / 2 - scrollWidth / 2).toFloat()
        val barY = (parent.height - paddingBottom - barHeight).toFloat()

        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.parseColor("#FFEAF1FE")
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = barHeight.toFloat()
        c.drawLine(barX, barY, barX + scrollWidth.toFloat(), barY, paint)

        val extent = parent.computeHorizontalScrollExtent()
        val range = parent.computeHorizontalScrollRange()
        val offset = parent.computeHorizontalScrollOffset()
        val maxEndX = (range - extent).toFloat()
        //可滑動
        if (maxEndX > 0) {
            val proportion = offset / maxEndX

            val scrollableDistance = scrollWidth - indicatorWidth

            val offsetX = scrollableDistance * proportion
            paint.color = Color.parseColor("#FF327BF9")
            c.drawLine(barX + offsetX, barY, barX + indicatorWidth.toFloat() + offsetX, barY, paint)
        } else {
            paint.color = Color.parseColor("#FF327BF9")
            c.drawLine(barX, barY, barX + scrollWidth.toFloat(), barY, paint)
        }
    }
}