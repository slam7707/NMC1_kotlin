package com.jh.nmc1

import android.app.Application
import android.content.Context
import android.util.Log
import com.jh.nmc1.MyApp.Companion.MyAppContext
import com.jh.nmc1.MyApp.Companion.MyAppSizeCX
import com.jh.nmc1.MyApp.Companion.MyAppSizeCY
import com.jh.nmc1.databinding.ActivityMainBinding

class MainProc(val binding : ActivityMainBinding) {
    val context : Context = MyAppContext()
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons

    init {
        Log.d("myLog", "------------------ MainProc Init");
        nmc1View = NMC1View(context)                    // 메인뷰 생성
        nmc1ComBtn = NMC1ComButtons(context, binding)   // 공통버튼 생성
   //     MPInitLayout();                               // 레이아웃 크기 조절
        Log.d("mylog", "--------------------- cx : ${MyAppSizeCX()} cy : ${MyAppSizeCY()}")
    }
    public fun MPElementsInit() {binding.root.addView(nmc1View)}
}

/*
val jhBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_jh_btn)
jhBtnLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
jhBtnLayout.layoutParams.height = 250    // jog, home fixed

val etcBtnLayout = binding.root.findViewById<LinearLayout>(R.id.nmc1_com_etc_btn)
etcBtnLayout.layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT
etcBtnLayout.layoutParams.height = 250   // etc oper fixed
*/