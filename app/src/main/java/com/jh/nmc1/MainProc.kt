package com.jh.nmc1

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.get
import com.jh.nmc1.databinding.ActivityMainBinding


class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        Log.d("myLog", "------------------ MainProc Init")
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

    public fun MPElementsInit() {
         binding.root.addView(nmc1View)

        /*
        val tv = binding.nmc1ComBtn.comView
        val tv_params = tv.layoutParams as LinearLayout.LayoutParams
        tv_params.width = LinearLayout.LayoutParams.MATCH_PARENT
        tv_params.height = LinearLayout.LayoutParams.MATCH_PARENT
        tv.layoutParams = tv_params
         */
    }
}