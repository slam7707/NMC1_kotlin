package com.jh.nmc1

import android.content.Context
import android.widget.LinearLayout

class ComButtons(context : Context) {
    val m_context: Context
    val l_out : LinearLayout
    init {
        m_context = context
        l_out = LinearLayout(m_context)

        l_out.layoutParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )
        l_out.orientation = LinearLayout.VERTICAL
    }

    public fun GetCommonButtons() : LinearLayout{
        return l_out
    }
}