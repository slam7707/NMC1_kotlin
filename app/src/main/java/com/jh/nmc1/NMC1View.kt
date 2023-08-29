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
        val deviceCX = display?.widthPixels
        val deviceCY = display?.heightPixels
        Log.d("deviceSize","cx = ${deviceCX}, cy = ${deviceCY}, cx int : ${display?.widthPixels!!.toInt()}, cy int : ${display?.heightPixels!!.toInt()}, ")

//       fun px2dp(px: Int, context: Context) = px / ((context.resources.displayMetrics.densityDpi.toFloat()) / DisplayMetrics.DENSITY_DEFAULT)
//       Log.d("deviceSize","cx = ${deviceCX}, cy = ${deviceCY}, ${px2dp(deviceCX!!, m_context)}, ${px2dp(deviceCY!!, m_context)}")
//       Log.d("deviceSize","cx = ${display?.widthPixels!!.toInt()}, cy = ${display?.heightPixels!!.toInt()}")

        // 디바이스 픽셀 구하기
        m_rect = Rect(0,0, display?.widthPixels!!.toInt(), display?.heightPixels!!.toInt())


        val sBarHeight : Int
        val resID : Int = m_context.resources.getIdentifier("status_bar_height", "dimen", "android")

        if (resID > 0) {
            sBarHeight = resources.getDimensionPixelSize(resID)
            Log.d("deviceSize", "---------------status bar : ${sBarHeight}")
        }
        // 상태바 크기 구하기

        val resID1 : Int = m_context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val nBarHeight : Int
        if (resID1 > 0) {
            nBarHeight = resources.getDimensionPixelSize(resID1)
            Log.d("deviceSize", "---------------navigation bar : ${nBarHeight}")
        }
        // 네비게이션바 크기 구하기
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.textSize = 100f

        val green = Paint()
        green.style = Paint.Style.STROKE
        green.strokeWidth = 5f
        green.color =Color.GREEN
        canvas?.drawRect(m_rect, green)
    }
}