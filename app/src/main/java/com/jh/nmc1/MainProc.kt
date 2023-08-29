package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        Log.d("myLog", "------------------ MainProc Init")

        val view : View = View(context)
        // 상태바 크기 구하기
        val sBarHeight : Int
        var resID : Int = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        if (resID > 0) {
            sBarHeight = view.resources.getDimensionPixelSize(resID)
            Log.d("deviceSize1", "---------------status bar : ${sBarHeight}")
        }

        // 네비게이션바 크기 구하기
        val nBarHeight : Int
        resID = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")

        if (resID > 0) {
            nBarHeight = view.resources.getDimensionPixelSize(resID)
            Log.d("deviceSize1", "---------------navigation bar : ${nBarHeight}")
        }



        nmc1View = NMC1View(context)
        nmc1ComBtn = NMC1ComButtons(context)

        val display = context.applicationContext?.resources?.displayMetrics     // 디바이스 크기 가져오기
        val cx = display?.widthPixels!!.toInt()
        val cy = display?.heightPixels!!.toInt()

        val infoLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_info_view)
        // 바인딩에서 include 된 레이아웃 id 가져오기

        infoLayout.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        infoLayout.layoutParams.height = cy - 500
        // 레이아웃 속성변경

        val commBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_btn)
        commBtnLayout.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        commBtnLayout.layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
    }

    public fun MPElementsInit() {binding.root.addView(nmc1View)}
}