package com.jh.nmc1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.Log
import android.view.View

class NMC1View (context : Context) : View(context) {

    val m_context: Context
    val m_rect : Rect

    init {
        Log.d("myLog", "------------------ NMC1View Init")
        this.m_context = context

        val display = m_context.applicationContext?.resources?.displayMetrics
//      val deviceCX = display?.widthPixels
//      val deviceCY = display?.heightPixels

        m_rect = Rect(0,0, display?.widthPixels!!.toInt(), display?.heightPixels!!.toInt())

//        fun px2dp(px: Int, context: Context) = px / ((context.resources.displayMetrics.densityDpi.toFloat()) / DisplayMetrics.DENSITY_DEFAULT)
//        Log.d("deviceSize","cx = ${deviceCX}, cy = ${deviceCY}, ${px2dp(deviceCX!!, m_context)}, ${px2dp(deviceCY!!, m_context)}")
        Log.d("deviceSize","cx = ${display?.widthPixels!!.toInt()}, cy = ${display?.heightPixels!!.toInt()}")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.textSize = 100f

        val green = Paint()
        green.style = Paint.Style.STROKE
        green.strokeWidth = 20f
        green.color =Color.GREEN
        canvas?.drawRect(m_rect, green)
    }
}