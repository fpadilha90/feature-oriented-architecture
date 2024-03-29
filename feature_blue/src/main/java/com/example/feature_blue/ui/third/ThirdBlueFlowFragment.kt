package com.example.feature_blue.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.feature_blue.R
import kotlinx.android.synthetic.main.fragment_third_blue_flow.*

class ThirdBlueFlowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third_blue_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text.setOnClickListener {
            findNavController().navigate(ThirdBlueFlowFragmentDirections.actionThirdBlueFlowFragmentToFourthBlueFlowFragment())
        }
    }
}