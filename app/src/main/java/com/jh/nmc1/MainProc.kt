package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        Log.d("myLog", "------------------ MainProc Init")

        val view : View = View(context)
        val rID : IntArray = IntArray(2)
        rID[0] = context.resources.getIdentifier("status_bar_height", "dimen", "android")       // status bar
        rID[1] = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")   // nevigation bar

        if (rID[0] > 0 && rID[1] > 0){
            rID[0] = view.resources.getDimensionPixelSize(rID[0])
            rID[1] = view.resources.getDimensionPixelSize(rID[1])

            Log.d("myLog", "---------------status bar : ${rID[0]}, nevi bar : ${rID[1]}")
        }
        val display = context.applicationContext?.resources?.displayMetrics     // 디바이스 크기 가져오기
//      val cx = display?.widthPixels!!.toInt()
        val cy = display?.heightPixels!!.toInt()        // 세로길이

        nmc1View = NMC1View(context)
        nmc1ComBtn = NMC1ComButtons(context, binding)

        val tablayouy = binding.root.findViewById<TabLayout>(R.id.tab_main)
        tablayouy.layoutParams.height = 150

        val infoLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_info_view)
        // 바인딩에서 include 된 레이아웃 id 가져오기

        infoLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        infoLayout.layoutParams.height = cy - 750 // 600 : common button, 150 : tab layout
        // 레이아웃 속성변경

        val commBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_btn)
        commBtnLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        commBtnLayout.layoutParams.height = 600
    }

    public fun MPElementsInit() {binding.root.addView(nmc1View)}
}