package com.app.tigr.ui.dialog.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.app.tigr.R
import com.app.tigr.common.TUtils

class TriangleView : View {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val oval = RectF()

    private val path = Path()

    private var colorShape = Color.BLACK
    private var avatarSide = 50

    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : this(ctx, attr, 0)

    constructor(ctx: Context, attr: AttributeSet?, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
        context.theme.obtainStyledAttributes(
                attr, R.styleable.TriangleView, 0, 0).apply {
            try {
                colorShape = getInt(R.styleable.TriangleView_android_color, Color.BLACK)
                avatarSide = getInt(R.styleable.TriangleView_avatarSide, 50)
            } finally {
                recycle()
            }
        }
        initPaint()
    }

    private fun initPaint() {
        paint.apply {
            color = colorShape
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 5F
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 10
        val desiredHeight = 50

        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            View.MeasureSpec.EXACTLY -> widthSize
            View.MeasureSpec.AT_MOST -> Math.min(desiredWidth, widthSize)
            View.MeasureSpec.UNSPECIFIED -> desiredWidth
            else -> desiredWidth
        }

        val height = when (heightMode) {
            View.MeasureSpec.EXACTLY -> heightSize
            View.MeasureSpec.AT_MOST -> Math.min(desiredHeight, heightSize)
            View.MeasureSpec.UNSPECIFIED -> desiredHeight
            else -> desiredHeight
        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas ?: return

        val x = 0F
        val y = 0F
        val height = height
        val width = width
        val circleDiameter = TUtils.convertDpToPx(avatarSide.toFloat())

        initOvalAroundAvatar(x, y, circleDiameter)
        drawTriangle(x, y, height, width)
        setShadow()
        canvas.drawPath(path, paint)
    }

    private fun setShadow() {
        setLayerType(LAYER_TYPE_SOFTWARE, paint)
        paint.setShadowLayer(4F, 0F, 0F, Color.GRAY)
    }

    private fun initOvalAroundAvatar(x: Float, y: Float, circleDiameter: Int) {
        oval.set(x, y, x + circleDiameter, y + circleDiameter)
    }

    private fun drawTriangle(x: Float, y: Float, height: Int, width: Int) {
        path.apply {
            reset()
            addArc(oval, 270F, 180F)
            moveTo(x, y)
            lineTo(x, y + height)
            lineTo(x + width, y + height / 2)
            lineTo(x, y)
            close()
        }
    }
}

