package com.example.healtharticles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.random.Random

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//simple article fragment class, it creates 'measure' tab
class MeasureFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    //parameters aren't used
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
        // Inflate the layout for this fragment
        container?.removeAllViews()
        val view = inflater.inflate(R.layout.fragment_measure, container, false)
        view?.findViewById<Button>(R.id.button_measure)?.setOnClickListener{
            view.findViewById<TextView>(R.id.glucose_measure)?.text= Random.nextInt(from = 60, until = 120 ).toString()
            view.findViewById<TextView>(R.id.heart_measure)?.text= Random.nextInt(from = 60, until = 100 ).toString()
            view.findViewById<TextView>(R.id.oxygen_measure)?.text= Random.nextInt(from = 95, until = 100 ).toString()
        }
        return view
    }


}