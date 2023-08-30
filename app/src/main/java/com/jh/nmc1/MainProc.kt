package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        Log.d("myLog", "------------------ MainProc Init");
        nmc1View = NMC1View(context)                    // 메인뷰 생성
        nmc1ComBtn = NMC1ComButtons(context, binding)   // 공통버튼 생성
        MPInitLayout();                                 // 레이아웃 크기 조절
    }

    public fun MPElementsInit() {binding.root.addView(nmc1View)}
    private fun MPInitLayout() {
        val view : View = View(context)
        val rID : IntArray = IntArray(2)
        rID[0] = context.resources.getIdentifier("status_bar_height", "dimen", "android")       // status bar
        rID[1] = context.resources.getIdentifier("navigation_bar_height", "dimen", "android")   // nevigation bar

        if (rID[0] > 0 && rID[1] > 0){
            rID[0] = view.resources.getDimensionPixelSize(rID[0])
            rID[1] = view.resources.getDimensionPixelSize(rID[1])

            Log.d("myLog", "---------------status bar : ${rID[0]}, nevi bar : ${rID[1]}")
        }
        val display = context.applicationContext?.resources?.displayMetrics     // 디바이스 크기 가져오기(상태, 네비게이션 빼고)
        val cx = display?.widthPixels!!.toInt()                                 // 가로길이 px
        val cy = display?.heightPixels!!.toInt()                                // 세로길이 px

        val tablayout = binding.root.findViewById<TabLayout>(R.id.tab_main)
        tablayout.layoutParams.height = 150      // 150 : tablayout

        val infoLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_info_view)
        // 바인딩에서 include 된 레이아웃 id 가져오기

        infoLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        infoLayout.layoutParams.height = (cy - 650) / 2 // 500 : common button, 150 : tab layout
        // 레이아웃 속성변경

        val vPager : ViewPager2 = binding.viewPager     // 뷰페이저 가져오기
        val vPagerParams = vPager.layoutParams          // 뷰페이저 레이아웃 파람
        vPagerParams.height = (cy - 650) / 2            // 뷰페이저 높이 설정
        vPager.layoutParams = vPagerParams              // 저장

        val jhBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_jh_btn)
        jhBtnLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        jhBtnLayout.layoutParams.height = 250    // jog, home fixed

        val etcBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_etc_btn)
        etcBtnLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        etcBtnLayout.layoutParams.height = 250   // etc oper fixed

        nmc1ComBtn.ComButtonInit(cx, cy, view)
    }
}