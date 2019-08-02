package com.example.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.app.R
import kotlinx.android.synthetic.main.fragment_second_app.*

class SecondAppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home_destination_button.setOnClickListener {
            findNavController().navigate(SecondAppFragmentDirections.actionSecondAppFragmentToBlueGraph())
        }
        error_action_button.setOnClickListener{
            findNavController().navigate(SecondAppFragmentDirections.actionSecondAppFragmentToGenericErrorFragment())
        }
    }
}