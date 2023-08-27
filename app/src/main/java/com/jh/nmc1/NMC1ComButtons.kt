package com.jh.nmc1

import android.content.Context
import android.widget.LinearLayout

class NMC1ComButtons(val context: Context) {
    val l_out : LinearLayout
    init {
        l_out = LinearLayout(context)

        l_out.layoutParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )

        l_out.orientation = LinearLayout.VERTICAL
    }

    public fun GetCommonButtons() : LinearLayout {
        return l_out
    }
}