package com.jh.nmc1

import android.content.Context
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import com.jh.nmc1.databinding.ActivityMainBinding

class NMC1ComButtons(val context: Context, val binding : ActivityMainBinding) {
     init {
        Log.d("myLog", "------------------ NMC1ComButtons Init")

         val btn1 = binding.nmc1ComJhBtn.jogBtn1
         val btn2 = binding.nmc1ComJhBtn.jogBtn2
         val btn3 = binding.nmc1ComJhBtn.jogBtn3

         val btnParams = LinearLayout.LayoutParams (
             LinearLayout.LayoutParams.WRAP_CONTENT,
             LinearLayout.LayoutParams.WRAP_CONTENT,
         )
         btnParams.setMargins(300, 100, 0, 0)
         btn1.layoutParams = btnParams
         btn2.layoutParams = btnParams
         btn3.layoutParams = btnParams

    }
}