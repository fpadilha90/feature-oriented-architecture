package com.example.feature_blue.domain.repository

import com.example.common.domain.exception.Failure
import com.example.common.domain.functional.Either
import com.example.feature_blue.domain.model.BlueModel

interface FeatureBlueRepository {
    suspend fun paintInBlue() : Either<Failure, List<BlueModel>>
}

