package com.example.feature_blue.ui.feature_blue

import com.example.common.BaseViewModel
import com.example.common.domain.interactor.UseCase
import com.example.feature_blue.domain.interactor.PaintInBlue

class BlueViewModel(private val paintInBlue: PaintInBlue) : BaseViewModel() {
    val uiState = BlueUiState()

    fun startToPaint() {
        paintInBlue(UseCase.None()) {
            it.either(::handleFailure) { blueModels ->
                uiState.count.value = blueModels.last().status
            }
        }
    }
}
