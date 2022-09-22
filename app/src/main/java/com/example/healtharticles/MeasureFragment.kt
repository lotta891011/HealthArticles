package com.example.healtharticles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.healtharticles.R
import kotlin.math.roundToInt
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MeasureFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MeasureFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        container?.removeAllViews()
        val view = inflater.inflate(R.layout.fragment_measure, container, false)
        view?.findViewById<Button>(R.id.button_measure)?.setOnClickListener{
            view.findViewById<TextView>(R.id.glucose_measure)?.text= Random.nextInt(from = 60, until = 120 ).toString()
            view.findViewById<TextView>(R.id.heart_measure)?.text= Random.nextInt(from = 60, until = 100 ).toString()
            view.findViewById<TextView>(R.id.oxygen_measure)?.text= Random.nextInt(from = 95, until = 100 ).toString()
        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment measureFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MeasureFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}