package com.app.tigr.ui.dialog.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.graphics.CornerPathEffect
import android.support.v7.widget.LinearLayoutCompat
import android.view.View
import com.app.tigr.common.TUtils
import org.jetbrains.anko.horizontalPadding


class MessageGroup : LinearLayoutCompat {
    private val paint = Paint()

    private val ovalLeft = RectF()

    private val path = Path()

    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : this(ctx, attr, 0)

    constructor(ctx: Context, attr: AttributeSet?, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
/*        val attrs = context.obtainStyledAttributes(attr, R.styleable.MessageView)
        attrs.recycle()*/

        val radius = 20.0f
        val cornerPathEffect = CornerPathEffect(radius)
        paint.pathEffect = cornerPathEffect

        orientation = VERTICAL
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.argb(100, 9, 8, 4)
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 5F

        val x = x + 2
        val y = y + 2
        val height = height - 4
        val width = width - 4
        val circleRadius = TUtils.convertDpToPx(50F) + 3

        initOvalToAvatar(x, y + 17, circleRadius)

        path.reset()
        path.addArc(ovalLeft, 270F, 180F)
        // path.addOval(ovalLeft, Path.Direction.CW)

        drawRect(x, y, height, width, circleRadius)

        path.close()

        canvas!!.drawPath(path, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var child: View
        for (i in 0 until childCount) {
            child = getChildAt(i)
            child.horizontalPadding = TUtils.convertDpToPx(60F)
            //child.layout(left, top, right, bottom)
        }
    }

    private fun initOvalToAvatar(x: Float, y: Float, height: Int) {
        ovalLeft.set(x, y, x + height, y + height)
    }

    private fun drawRect(x: Float, y: Float, height: Int, width: Int, avatarSide: Int) {
        path.moveTo(x + avatarSide / 2, y)
        // draw  |
        path.lineTo(x + avatarSide / 2, y + avatarSide)
        // draw  |
        path.lineTo(x + avatarSide / 2, y + height)
        // draw  _
        path.lineTo(x + width - avatarSide / 2, y + height)
        // draw     |
        path.lineTo(x + width - avatarSide / 2, y)
        // draw  -
        path.lineTo(x + avatarSide / 2, y)
    }
}

