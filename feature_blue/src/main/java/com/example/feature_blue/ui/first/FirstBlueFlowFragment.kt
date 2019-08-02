package com.example.feature_blue.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.feature_blue.R
import kotlinx.android.synthetic.main.fragment_first_blue_flow.*

class FirstBlueFlowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_first_blue_flow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text.setOnClickListener {
            findNavController().navigate(FirstBlueFlowFragmentDirections.actionFirstBlueFlowFragmentToSecondBlueFlowFragment())
        }
        text.setOnLongClickListener {
            findNavController().navigate(FirstBlueFlowFragmentDirections.actionFirstBlueFlowFragmentToThirdBlueFlowFragment())
            true
        }
    }
}