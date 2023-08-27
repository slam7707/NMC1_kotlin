package com.jh.nmc1

import android.content.Context
import android.util.Log

import android.view.View
import com.jh.nmc1.databinding.ActivityMainBinding

class MainProc(val context: Context, val binding : ActivityMainBinding) {
    val nmc1View : NMC1View
    val nmc1ComBtn : NMC1ComButtons
    init {
        nmc1View = NMC1View(context)
        nmc1ComBtn = NMC1ComButtons((context))
    }

    public fun MPGetMainView() : NMC1View {
        return nmc1View
    }

    public fun MPElementsInit() {
        binding.root.addView(nmc1View)

        Log.d("myLog", "-------------------------------- 1")
    }




}