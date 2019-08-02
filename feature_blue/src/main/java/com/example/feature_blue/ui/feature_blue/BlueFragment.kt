package com.example.feature_blue.ui.feature_blue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.feature_blue.R
import com.example.feature_blue.databinding.FragmentFeatureBlueBinding
import kotlinx.android.synthetic.main.fragment_feature_blue.*
import org.koin.androidx.viewmodel.ext.viewModel

class BlueFragment : Fragment() {

    private val blueViewModel: BlueViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentFeatureBlueBinding>(inflater, R.layout.fragment_feature_blue, container, false).apply {
            lifecycleOwner = this@BlueFragment
            uiState = blueViewModel.uiState
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addListeners(view)
    }

    private fun addListeners(view: View) {
        view.setOnClickListener {
            blueViewModel.startToPaint()
        }
        custom_component.setOnClickListener {
            findNavController().navigate(BlueFragmentDirections.actionBlueFragmentToPurple())
        }
        text.setOnClickListener {
            findNavController().navigate(BlueFragmentDirections.actionBlueFragmentToBlueFlowActivity())
        }
    }
}