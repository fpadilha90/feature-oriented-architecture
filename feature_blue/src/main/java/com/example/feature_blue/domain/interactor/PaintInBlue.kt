package com.example.feature_blue.domain.interactor

import com.example.common.domain.interactor.UseCase
import com.example.feature_blue.domain.model.BlueModel
import com.example.feature_blue.domain.repository.FeatureBlueRepository

class PaintInBlue(private val featureBlueRepository: FeatureBlueRepository) :
    UseCase<List<BlueModel>, UseCase.None>() {

    override suspend fun run(params: None) =
        featureBlueRepository.paintInBlue()

}
