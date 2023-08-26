package com.jh.nmc1
import android.content.Context
import android.view.View

class MainProc(val context: Context) {
    val nmc1View : NMC1View
    init {
        nmc1View = NMC1View(context)
    }

    public fun MPGetMainView() : NMC1View {
        return nmc1View
    }
}