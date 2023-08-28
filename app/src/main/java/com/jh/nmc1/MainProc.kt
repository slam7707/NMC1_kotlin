package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.jh.nmc1.databinding.ActivityMainBinding


class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        Log.d("myLog", "------------------ MainProc Init")
        nmc1View = NMC1View(context)
        nmc1ComBtn = NMC1ComButtons(context)
    }

    public fun MPGetMainView() : NMC1View {
        return nmc1View
    }

    public fun MPElementsInit() {
         binding.root.addView(nmc1View)

         val lout : LinearLayout = binding.root.findViewById(R.id.nmc1_com_btn)
        // 바인딩에서 include 된 레이아웃 id 가져오기

        lout.layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
        lout.layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT
        // 레이아웃 속성변경

        val tv = binding.nmc1ComBtn.comView

        val tv_params = tv.layoutParams as LinearLayout.LayoutParams
        tv_params.width = LinearLayout.LayoutParams.MATCH_PARENT
        tv_params.height = LinearLayout.LayoutParams.MATCH_PARENT
        tv.layoutParams = tv_params
    }
}