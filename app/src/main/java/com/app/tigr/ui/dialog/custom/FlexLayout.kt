package com.app.tigr.ui.dialog.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.graphics.Point
import android.view.WindowManager

class FlexLayout : RelativeLayout {

    private var deviceWidth: Int = 0

    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : this(ctx, attr, 0)

    constructor(ctx: Context, attr: AttributeSet?, defStyleAttr: Int) : super(ctx, attr, defStyleAttr)

    init {
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val deviceDisplay = Point()
        display.getSize(deviceDisplay)
        deviceWidth = deviceDisplay.x
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec)
/*        var width  = 0
        var height  = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)

            if (child.visibility == View.GONE) continue

            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            width = child.measuredWidth
            height = child.measuredHeight



        }*/


        var maxHeight = 0
        var maxWidth = 0
        var childState = 0
        var mLeftWidth = 0
        var rowCount = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)

            if (child.visibility == View.GONE)
                continue

            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            maxWidth += Math.max(maxWidth, child.measuredWidth)
            mLeftWidth += child.measuredWidth

            if (mLeftWidth / deviceWidth > rowCount) {
                maxHeight += child.measuredHeight
                rowCount++
            } else {
                maxHeight = Math.max(maxHeight, child.measuredHeight)
            }
            childState = View.combineMeasuredStates(childState, child.measuredState)
        }

        maxHeight = Math.max(maxHeight, suggestedMinimumHeight)
        maxWidth = Math.max(maxWidth, suggestedMinimumWidth)

        setMeasuredDimension(View.resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                View.resolveSizeAndState(maxHeight, heightMeasureSpec, childState shl View.MEASURED_HEIGHT_STATE_SHIFT))
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        val count = childCount
        var curWidth: Int
        var curHeight: Int
        var curLeft: Int
        var curTop: Int
        var maxHeight: Int

        //get the available size of child view
        val childLeft = this.paddingLeft
        val childTop = this.paddingTop
        val childRight = this.measuredWidth - this.paddingRight
        val childBottom = this.measuredHeight - this.paddingBottom
        val childWidth = childRight - childLeft
        val childHeight = childBottom - childTop

        maxHeight = 0
        curLeft = childLeft
        curTop = childTop

        for (i in 0 until count) {
            val child = getChildAt(i)

            if (child.visibility == View.GONE)
                return

            //Get the maximum size of the child
            child.measure(View.MeasureSpec.makeMeasureSpec(childWidth, View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(childHeight, View.MeasureSpec.AT_MOST))
            curWidth = child.measuredWidth
            curHeight = child.measuredHeight
            //wrap is reach to the end
            if (curLeft + curWidth >= childRight) {
                curLeft = childLeft
                curTop += maxHeight
                maxHeight = 0
            }
            //do the layout
            child.layout(curLeft, curTop, curLeft + curWidth, curTop + curHeight)
            //store the max height
            if (maxHeight < curHeight)
                maxHeight = curHeight
            curLeft += curWidth
        }
    }
}

