package com.jh.nmc1

import android.content.Context
import android.widget.LinearLayout

class ComButtons(context : Context) {
    val m_context: Context

    init {
        m_context = context
        val l_out = LinearLayout(m_context)
        l_out.layoutParams = LinearLayout.LayoutParams (
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        l_out.orientation = LinearLayout.VERTICAL
    }
}