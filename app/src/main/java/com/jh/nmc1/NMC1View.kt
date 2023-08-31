package com.jh.nmc1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View

class NMC1View (context : Context) : View(context) {

    val m_context: Context
    val m_rect : Rect
    val m_cx : Int
    val m_cy : Int
    val m_paint_rect : Paint
    val m_paint_string : Paint
    init {
        Log.d("myLog", "------------------ NMC1View Init")
        m_paint_rect = Paint()
        m_paint_string = Paint()
        this.m_context = context
        val display = m_context.applicationContext?.resources?.displayMetrics
        m_cx = display?.widthPixels!!.toInt()                                             // 가로길이 px
        m_cy = (display?.heightPixels!!.toInt() - 650) / 2                                // 세로길이 px

        m_rect = Rect(0, 150, m_cx, m_cy + 150)                           // 150 : 탭레이아웃 높이


        /*
        val display = m_context.applicationContext?.resources?.displayMetrics
        val deviceCX = display?.widthPixels
        val deviceCY = display?.heightPixels
        Log.d("deviceSize","cx = ${deviceCX}, cy = ${deviceCY}, cx int : ${display?.widthPixels!!.toInt()}, cy int : ${display?.heightPixels!!.toInt()}, ")

       fun px2dp(px: Int, context: Context) = px / ((context.resources.displayMetrics.densityDpi.toFloat()) / DisplayMetrics.DENSITY_DEFAULT)
       Log.d("deviceSize","cx = ${deviceCX}, cy = ${deviceCY}, ${px2dp(deviceCX!!, m_context)}, ${px2dp(deviceCY!!, m_context)}")
       Log.d("deviceSize","cx = ${display?.widthPixels!!.toInt()}, cy = ${display?.heightPixels!!.toInt()}")

        // 디바이스 픽셀 구하기
        m_rect = Rect(0,0, display?.widthPixels!!.toInt(), display?.heightPixels!!.toInt())
        // 네비게이션바 크기 구하기
         */
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        m_paint_rect.color = Color.GREEN
        m_paint_rect.style = Paint.Style.STROKE
        m_paint_rect.strokeWidth = 3.0f
        m_paint_rect.textSize = 100f

        m_paint_string.color = Color.WHITE
        m_paint_string.style = Paint.Style.FILL
        m_paint_string.strokeWidth = 3.0f
        m_paint_string.textSize = 100f
        m_paint_string.textAlign = Paint.Align.CENTER

        var cx = m_cx / 10
        var cy = m_cy / 20

        canvas?.drawRect(Rect(0, 150, m_cx, cy * 3 + 150), m_paint_rect)
        canvas?.drawText("Position : 0.000 mm", 0.0f + cx * 5, cy * 3 + 150f, m_paint_string)

        canvas?.drawRect(Rect(0, cy * 3 + 150, m_cx, cy * 6 + 150), m_paint_rect)
        canvas?.drawText("Velocity : 0 mm/min", 0.0f + cx * 5, cy * 6 + 150f, m_paint_string)

        m_paint_string.textAlign = Paint.Align.RIGHT
        m_paint_string.textSize = cy + 0.0f

        val title = arrayOf<String>("Start Position :", "End Position :", "Oper Speed :", "Delay Time :", "Step Count :", "Repeat Count :")

        for (i in 0..5) {
            canvas?.drawRect(Rect(0, (cy * 6 + 150) + (cy * i * 2) + (cy / 2), m_cx, (cy * 8 + 150) + (cy * i * 2) + (cy / 2)), m_paint_rect)
            canvas?.drawText(title[i], cx * 3 + 0.0f + (cy / 2), (cy * 8 + 150) + (cy * i * 2) + 0.0f + (cy / 2), m_paint_string)
        }
        /*
        m_paint_string.textAlign = Paint.Align.RIGHT
        m_paint_string.textSize = 50f
        val title = arrayOf<String>("Start Position :", "End Position :", "Oper Speed :", "Delay Time :", "Step Count :", "Repeat Count :")
        for (i in 0..5){
            canvas?.drawText(title[i], m_cx / 3 + 0.0f, cy * 2 + 210f + i * 60f, m_paint_string)
        }

         */

        /*
        m_paint.color = Color.GREEN
        m_paint.textSize = 100f

        val green = Paint()
        green.style = Paint.Style.STROKE
        green.strokeWidth = 3f
        green.color =Color.GREEN
        canvas?.drawRect(m_rect, green)
         */
    }
}