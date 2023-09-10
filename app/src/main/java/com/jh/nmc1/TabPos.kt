package com.jh.nmc1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.jh.nmc1.MyApp.Companion.MyAppSizeCX
import com.jh.nmc1.MyApp.Companion.MyAppSizeCY
import com.jh.nmc1.databinding.ActivityMainBinding
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TabPos.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabPos(val binding : ActivityMainBinding) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
//        val display = context.applicationContext?.resources?.displayMetrics     // 디바이스 크기 가져오기(상태, 네비게이션 빼고)
//        val cx = display?.widthPixels!!.toInt()                                 // 가로길이 px
//        val cy = display?.heightPixels!!.toInt()                                // 세로길이 px

//      val btn = binding.viewPager.findViewById<ConstraintLayout>(R.id.tap_pos_layout)

        Log.d("tap_pos", "---------------- oncreate")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tab_pos, container, false)
        // TextView를 가져옵니다.
        val btn = view.findViewById<Button>(R.id.tab_pos_btn_0)
//      val myTextView = view.findViewById<TextView>(R.id.tap_pos_end_pos_title)

        return inflater.inflate(R.layout.fragment_tab_pos, container, false)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TabPos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(binding : ActivityMainBinding/*param1: String, param2: String*/) =
            TabPos(binding).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}